package br.com.dikastis.app.ui.task.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dikastis.app.databinding.TaskBoxBinding
import br.com.dikastis.app.data.model.Task

class TaskAdapter (
    private val tasks: Array<Task>,
    private val inflater: LayoutInflater
) :
    RecyclerView.Adapter<TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = TaskBoxBinding.inflate(inflater, parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bindTo(tasks[position])
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

}