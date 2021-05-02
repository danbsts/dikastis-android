package br.com.dikastis.app.team

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dikastis.app.databinding.TeamBoxBinding
import br.com.dikastis.app.model.Team

class TeamAdapter (
    private val teams: List<Team>,
    private val inflater: LayoutInflater
) :
    RecyclerView.Adapter<TeamViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val binding = TeamBoxBinding.inflate(inflater, parent, false)
        return TeamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindTo(teams[position])
    }

    override fun getItemCount(): Int {
        return teams.size
    }

}