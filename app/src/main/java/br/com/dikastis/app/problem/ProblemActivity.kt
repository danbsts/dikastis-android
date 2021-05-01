package br.com.dikastis.app.problem

import android.R
import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dikastis.app.databinding.ActivityProblemBinding
import br.com.dikastis.app.databinding.ActivityTaskBinding
import br.com.dikastis.app.model.Constants
import br.com.dikastis.app.overview.OverviewAdapter
import br.com.dikastis.app.task.TaskAdapter

class ProblemActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProblemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProblemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerViewStatus = binding.statusList

        val submissionId = intent.getIntExtra("submissionId", -1)

        recyclerViewStatus.apply {
            layoutManager = LinearLayoutManager(this@ProblemActivity, LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(DividerItemDecoration(this@ProblemActivity, DividerItemDecoration.HORIZONTAL))
            adapter = StatusAdapter(
                Constants.submissions,
                layoutInflater
            )
        }

        if (submissionId != -1) {
            updateToSubmission(submissionId)
        }

    }

    fun updateToSubmission(submissionId : Int) {
        binding.submissionId.text = "Submission: $submissionId"
    }

}