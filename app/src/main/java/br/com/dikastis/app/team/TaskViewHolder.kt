package br.com.dikastis.app.team

import androidx.recyclerview.widget.RecyclerView
import br.com.dikastis.app.databinding.TaskBoxBinding
import br.com.dikastis.app.model.Task

class TaskViewHolder(private val binding: TaskBoxBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindTo(task: Task) {
        binding.name.text = task.name
        binding.endDate.text = task.endDate.toString()
//        binding.root.setOnClickListener {
//            val c = binding.name.context
//            val intentExplicito = Intent(c, OrganizationActivity::class.java)
//            intentExplicito.putExtra("id", organization.id)
//            c.startActivity(intentExplicito)
//        }
    }
}
