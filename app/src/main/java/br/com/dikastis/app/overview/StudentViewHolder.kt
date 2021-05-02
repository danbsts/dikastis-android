package br.com.dikastis.app.overview

import android.content.Intent
import android.util.Log
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.dikastis.app.databinding.StudentsBoxBinding
import br.com.dikastis.app.model.Student
import br.com.dikastis.app.problem.ProblemActivity

class OverviewViewHolder(private val binding: StudentsBoxBinding, private val problems: ArrayAdapter<String>):
        RecyclerView.ViewHolder(binding.root) {

    fun bindTo(student : Student) {
        binding.name.text = student.name
        binding.progress.text = "${student.solved}/${student.total}"
        binding.spinner.setAdapter(problems)
        binding.button.setOnClickListener{
            val c = binding.name.context
            val intentExplicito = Intent(c, ProblemActivity::class.java)
            intentExplicito.putExtra("id", binding.spinner.selectedItem.toString())
            intentExplicito.putExtra("name", student.name)
            c.startActivity(intentExplicito)
        }
    }
}