package br.com.dikastis.app.problem

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import br.com.dikastis.app.R
import br.com.dikastis.app.databinding.ActivityProblemBinding
import java.io.File


class RecordingManager(private val context: Context, private val binding: ActivityProblemBinding) {
    private var mediaRecorder : MediaRecorder? = null
    private var state : Boolean = false
    private var recordingStopped : Boolean = false
    private var submissionId : String = "0"
    private var folderPath : String = (context.getExternalFilesDir(null)?.absolutePath ?: "") + "/dikastis/"

    @SuppressLint("UseCompatLoadingForColorStateLists")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun startRecording() {
        try {
            setUpRecorder()
            mediaRecorder?.prepare()
            mediaRecorder?.start()
            state = true
            binding.buttonStartAudio.backgroundTintList = context.resources.getColorStateList(R.color.red)
            binding.buttonShareAudio.backgroundTintList = context.resources.getColorStateList(R.color.red)
            binding.buttonPauseResumeAudio.backgroundTintList = context.resources.getColorStateList(R.color.dikastis)
            binding.buttonStopAudio.backgroundTintList =  context.resources.getColorStateList(R.color.dikastis)
            Toast.makeText(context, "Recording...", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun setSubmissionId(id: String) {
        submissionId = id
    }

    private fun setUpRecorder() {
        val fileName = "recording_submission_$submissionId.mp3"

        context.getExternalFilesDir(null)
        val filePath = File(folderPath)
        filePath.mkdirs()

        mediaRecorder = MediaRecorder()
        mediaRecorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecorder?.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        mediaRecorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        mediaRecorder?.setOutputFile(filePath.absolutePath + fileName)
    }

    @SuppressLint("UseCompatLoadingForColorStateLists")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun stopRecording(){
        if(state){
            mediaRecorder?.stop()
            mediaRecorder?.release()
            state = false
            binding.buttonStartAudio.backgroundTintList = context.resources.getColorStateList(R.color.dikastis)
            binding.buttonShareAudio.backgroundTintList = context.resources.getColorStateList(R.color.dikastis)
            binding.buttonPauseResumeAudio.backgroundTintList = context.resources.getColorStateList(R.color.red)
            binding.buttonStopAudio.backgroundTintList =  context.resources.getColorStateList(R.color.red)
        }else{
            Toast.makeText(context, "Recording saved!", Toast.LENGTH_LONG).show()
        }
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.N)
    fun pauseRecording() {
        if(state) {
            if(!recordingStopped){
                Toast.makeText(context, "Recording paused!", Toast.LENGTH_SHORT).show()
                mediaRecorder?.pause()
                recordingStopped = true
                binding.buttonPauseResumeAudio.text = "Resume"
            }else{
                resumeRecording()
            }
        }
    }

    fun shareRecording(): Intent {
        val fileName = "recording_submission_$submissionId.mp3"

        val uri: Uri = Uri.parse(folderPath + fileName)
        val share = Intent(Intent.ACTION_SEND)
        share.type = "audio/*"
        share.putExtra(Intent.EXTRA_STREAM, uri)

        return share
    }

    @SuppressLint("SetTextI18n")
    @TargetApi(Build.VERSION_CODES.N)
    private fun resumeRecording() {
        Toast.makeText(context, "Recording restored!", Toast.LENGTH_SHORT).show()
        mediaRecorder?.resume()
        binding.buttonPauseResumeAudio.text = "Pause"
        recordingStopped = false
    }

    private fun hasMicrophone(): Boolean {
        return context.packageManager.hasSystemFeature(
            PackageManager.FEATURE_MICROPHONE
        )
    }
}