package br.com.dikastis.app.problem

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
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

    private var submissionId : Int = 0

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProblemBinding.inflate(layoutInflater)
        recordingManager = RecordingManager(this, binding)
        setContentView(binding.root)

        val recyclerViewStatus = binding.statusList
        val startAudioButton = binding.buttonStartAudio
        val pauseResumeAudioButton = binding.buttonPauseResumeAudio
        val stopAudioButton = binding.buttonStopAudio
        val shareAudioButton = binding.buttonShareAudio

        recyclerViewStatus.apply {
            layoutManager = LinearLayoutManager(this@ProblemActivity, LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(DividerItemDecoration(this@ProblemActivity, DividerItemDecoration.HORIZONTAL))
            adapter = StatusAdapter(
                Constants.submissions,
                layoutInflater
            )
        }

        if (submissionId != 0) {
            updateToSubmission(submissionId)
        }

        startAudioButton.setOnClickListener {
            if (!hasNecessaryPermissions()) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO),0)
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
            startActivity(Intent.createChooser(recordingManager.shareRecording(), "Share audio result"))
        }
    }

    @SuppressLint("SetTextI18n")
    fun updateToSubmission(submissionId : Int) {
        binding.submissionId.text = "Submission: $submissionId"
    }

    private fun hasNecessaryPermissions(): Boolean {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
    }

}