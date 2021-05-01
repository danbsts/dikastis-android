package br.com.dikastis.app.problem

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import br.com.dikastis.app.databinding.ActivityProblemBinding
import br.com.dikastis.app.model.Constants
import br.com.dikastis.app.model.Submission

class ProblemBroadcastReceiver (private var binding: ActivityProblemBinding) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val id = intent?.getStringExtra("submissionId")

        if (id != null) {
            updateToSubmission(id)
            Toast.makeText(context, "Submission set", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("SetTextI18n")
    fun updateToSubmission(submissionId: String) {
        binding.submissionId.text = "Submission: $submissionId"
        // TODO: Call someone to receive submission by id
        var submission : Submission = Constants.submissions[submissionId.toInt() - 1]

        binding.statusName.text = submission.status
        binding.languageName.text = "Language: " + submission.language
        binding.runtime.text = "Runtime: " + submission.runtime.toString() + "ms"
        binding.code.text = submission.code
    }
}