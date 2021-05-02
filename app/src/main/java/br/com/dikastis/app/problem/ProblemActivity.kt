package br.com.dikastis.app.problem

import android.Manifest
import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dikastis.app.databinding.ActivityProblemBinding
import br.com.dikastis.app.model.Constants

class ProblemActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProblemBinding
    private lateinit var recordingManager : RecordingManager
    private var receiver: BroadcastReceiver? = null

    private var submissionId : Int = 0

    @SuppressLint("ResourceAsColor", "SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProblemBinding.inflate(layoutInflater)
        recordingManager = RecordingManager(this, binding)
        setContentView(binding.root)
        configureReceiver()

        val problemName = intent.getStringExtra("problemName")
        val studentName = intent.getStringExtra("studentName")

        binding.problemName.text = "Problem: $problemName"
        binding.studentName.text = "Student: $studentName"

        val recyclerViewStatus = binding.statusList
        val startAudioButton = binding.buttonStartAudio
        val pauseResumeAudioButton = binding.buttonPauseResumeAudio
        val stopAudioButton = binding.buttonStopAudio
        val shareAudioButton = binding.buttonShareAudio

        recyclerViewStatus.apply {
            layoutManager = LinearLayoutManager(
                this@ProblemActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            addItemDecoration(
                DividerItemDecoration(
                    this@ProblemActivity,
                    DividerItemDecoration.HORIZONTAL
                )
            )
            adapter = StatusAdapter(
                Constants.submissions,
                layoutInflater
            )
        }

        startAudioButton.setOnClickListener {
            if (!hasNecessaryPermissions()) {
                ActivityCompat.requestPermissions(
                    this, arrayOf(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.RECORD_AUDIO
                    ), 0
                )
            } else {
                recordingManager.startRecording()
            }
        }

        pauseResumeAudioButton.setOnClickListener{
             recordingManager.pauseRecording()
        }

        stopAudioButton.setOnClickListener {
            recordingManager.stopRecording()
        }

        shareAudioButton.setOnClickListener {
            startActivity(
                Intent.createChooser(
                    recordingManager.shareRecording(),
                    "Share audio result"
                )
            )
        }

    }

    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }

    private fun hasNecessaryPermissions(): Boolean {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                && hasMicrophone()
    }

    private fun hasMicrophone(): Boolean {
        return packageManager.hasSystemFeature(
            PackageManager.FEATURE_MICROPHONE
        )
    }

    private fun configureReceiver() {
        val filter = IntentFilter()
        filter.addAction("br.com.dikastis.submissionChange")
        receiver = ProblemBroadcastReceiver(binding)
        registerReceiver(receiver, filter)
    }
}