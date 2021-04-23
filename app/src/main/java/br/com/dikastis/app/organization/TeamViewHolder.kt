package br.com.dikastis.app.organization

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import br.com.dikastis.app.databinding.TeamBoxBinding
import br.com.dikastis.app.model.Team

class TeamViewHolder (private val binding: TeamBoxBinding):
    RecyclerView.ViewHolder(binding.root) {

    fun bindTo(team : Team) {
        binding.name.text = team.name
//        binding.root.setOnClickListener {
//            val c = binding.name.context
//            val intentExplicito = Intent(c, OrganizationActivity::class.java)
//            intentExplicito.putExtra("id", organization.id)
//            c.startActivity(intentExplicito)
//        }
        "${team.membersCount} members".also { binding.membersCount.text = it }
        "${team.adminsCount} admins".also { binding.adminsCount.text = it }
    }
}
