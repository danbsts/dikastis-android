package br.com.dikastis.app.team

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dikastis.app.databinding.ActivityTeamBinding
import br.com.dikastis.app.model.Constants
import br.com.dikastis.app.task.TaskAdapter

class TeamActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTeamBinding
    private val teamViewModel: TeamViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val teamId = intent.getStringExtra("id")
        teamViewModel.fetchTeam(teamId)

        val recyclerViewTeams = binding.taskList
        recyclerViewTeams.apply {
            layoutManager = LinearLayoutManager(this@TeamActivity)
            addItemDecoration(DividerItemDecoration(this@TeamActivity, DividerItemDecoration.VERTICAL))
            teamViewModel.team.observe(this@TeamActivity, {
                binding.teamName.text = it.name
                adapter = TaskAdapter(
                    it.tasks,
                    layoutInflater
                )
            })
        }
    }

}
