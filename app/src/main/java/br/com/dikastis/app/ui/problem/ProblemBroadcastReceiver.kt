package br.com.dikastis.app.ui.problem

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import br.com.dikastis.app.databinding.ActivityProblemBinding
import br.com.dikastis.app.data.model.Submission

class ProblemBroadcastReceiver (
    private var binding: ActivityProblemBinding,
    private var submissions: List<Submission>) : BroadcastReceiver()
{
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
        var submission : Submission = submissions[submissionId.toInt() - 1]

        binding.statusName.text = submission.status
        binding.languageName.text = "Language: " + submission.language
        binding.runtime.text = "Runtime: " + submission.runtime.toString() + "ms"
        binding.code.text = submission.code
    }
}