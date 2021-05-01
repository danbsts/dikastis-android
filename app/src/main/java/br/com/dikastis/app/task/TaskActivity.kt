package br.com.dikastis.app.task

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dikastis.app.databinding.ActivityTaskBinding
import br.com.dikastis.app.model.Constants
import br.com.dikastis.app.overview.OverviewActivity
import br.com.dikastis.app.overview.OverviewAdapter

class TaskActivity : AppCompatActivity(){
    private lateinit var binding : ActivityTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerViewStudents = binding.studentsList
        val button = binding.buttonChart
        recyclerViewStudents.apply {
            layoutManager = LinearLayoutManager(this@TaskActivity)
            addItemDecoration(DividerItemDecoration(this@TaskActivity, DividerItemDecoration.VERTICAL))
            adapter = OverviewAdapter(
                    Constants.students,
                    Constants.problems,
                    layoutInflater
            )
        }

        button.setOnClickListener {
            val c = binding.buttonChart.context
            val intentExplicito = Intent(c, OverviewActivity::class.java)
            c.startActivity(intentExplicito)
        }

    }

}
