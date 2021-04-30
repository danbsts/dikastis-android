package br.com.dikastis.app.team

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dikastis.app.databinding.ActivityTeamBinding
import br.com.dikastis.app.model.Constants
import br.com.dikastis.app.task.TaskAdapter

class TeamActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTeamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Chegamos aqui")

        binding = ActivityTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerViewTeams = binding.taskList
        val id = intent.getStringExtra("id")
        recyclerViewTeams.apply {
            layoutManager = LinearLayoutManager(this@TeamActivity)
            addItemDecoration(DividerItemDecoration(this@TeamActivity, DividerItemDecoration.VERTICAL))
            adapter = TaskAdapter(
                Constants.tasks,
                layoutInflater
            )
        }

    }

}
