package br.com.dikastis.app.task

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import br.com.dikastis.app.databinding.TaskBoxBinding
import br.com.dikastis.app.model.Task

class TaskViewHolder(private val binding: TaskBoxBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindTo(task: Task) {
        binding.name.text = task.name
        binding.endDate.text = task.endDate.toString()
        binding.root.setOnClickListener {
            val c = binding.name.context
            val intentExplicito = Intent(c, TaskActivity::class.java)
            intentExplicito.putExtra("id", task.name)
            c.startActivity(intentExplicito)
        }
    }
}
