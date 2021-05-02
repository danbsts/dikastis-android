package br.com.dikastis.app.team

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import br.com.dikastis.app.databinding.TeamBoxBinding
import br.com.dikastis.app.model.Team

class TeamViewHolder (private val binding: TeamBoxBinding):
    RecyclerView.ViewHolder(binding.root) {

    fun bindTo(team : Team) {
        binding.name.text = team.name
        binding.root.setOnClickListener {
            val c = binding.name.context
            val intentExplicito = Intent(c, TeamActivity::class.java)
            intentExplicito.putExtra("id", team.id)
            intentExplicito.putExtra("name", team.name)
            c.startActivity(intentExplicito)
        }
        "${team.membersCount} members".also { binding.membersCount.text = it }
        "${team.adminsCount} admins".also { binding.adminsCount.text = it }
    }
}
