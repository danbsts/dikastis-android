package br.com.dikastis.app.task

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dikastis.app.databinding.ActivityTaskBinding
import br.com.dikastis.app.model.Constants
import br.com.dikastis.app.overview.OverviewActivity
import br.com.dikastis.app.overview.StudentAdapter

class TaskActivity : AppCompatActivity(){
    private lateinit var binding : ActivityTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerViewOverview = binding.studentsList
        val taskName = intent.getStringExtra("name")
        binding.taskName.text = taskName
        val items = arrayOf("1", "2", "three")
        val dropDownItems: ArrayAdapter<String> = ArrayAdapter(this@TaskActivity,
            R.layout.simple_spinner_dropdown_item, items)
        recyclerViewOverview.apply {
            layoutManager = LinearLayoutManager(this@TaskActivity)
            addItemDecoration(DividerItemDecoration(this@TaskActivity, DividerItemDecoration.VERTICAL))
            adapter = StudentAdapter(
                    Constants.students,
                    dropDownItems,
                    layoutInflater
            )
        }

        val button = binding.buttonChart
        button.setOnClickListener {
            val c = binding.buttonChart.context
            val intentExplicito = Intent(c, OverviewActivity::class.java)
            c.startActivity(intentExplicito)
        }

    }

}
