package br.com.dikastis.app.ui.team.adapter

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import br.com.dikastis.app.databinding.TeamBoxBinding
import br.com.dikastis.app.data.model.Team
import br.com.dikastis.app.ui.team.TeamActivity

class TeamViewHolder (private val binding: TeamBoxBinding):
    RecyclerView.ViewHolder(binding.root) {

    fun bindTo(team : Team) {
        binding.name.text = team.name
        binding.root.setOnClickListener {
            val c = binding.name.context
            val intentExplicito = Intent(c, TeamActivity::class.java)
            intentExplicito.putExtra("id", team.id)
            c.startActivity(intentExplicito)
        }
        "${team.membersCount} members".also { binding.membersCount.text = it }
        "${team.adminsCount} admins".also { binding.adminsCount.text = it }
    }
}
