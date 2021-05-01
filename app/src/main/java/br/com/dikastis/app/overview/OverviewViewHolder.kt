package br.com.dikastis.app.overview

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import br.com.dikastis.app.R
import br.com.dikastis.app.databinding.StudentsBoxBinding
import br.com.dikastis.app.databinding.TeamBoxBinding
import br.com.dikastis.app.model.Student
import br.com.dikastis.app.model.Team
import br.com.dikastis.app.team.TeamActivity

class OverviewViewHolder (
        private val binding: StudentsBoxBinding):
        RecyclerView.ViewHolder(binding.root) {

    fun bindTo(student : Student) {
        binding.name.text = student.name
        binding.email.text = student.email
    }
}