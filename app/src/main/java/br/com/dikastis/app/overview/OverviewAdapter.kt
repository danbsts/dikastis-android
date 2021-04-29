package br.com.dikastis.app.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dikastis.app.databinding.StudentsBoxBinding
import br.com.dikastis.app.databinding.TaskBoxBinding
import br.com.dikastis.app.model.Problem
import br.com.dikastis.app.model.Student
import br.com.dikastis.app.model.Task
import br.com.dikastis.app.task.TaskViewHolder

class OverviewAdapter (private val students: Array<Student>,
                       private val problems: Array<Problem>,
                       private val inflater: LayoutInflater) :
        RecyclerView.Adapter<OverviewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewViewHolder {
        val binding = StudentsBoxBinding.inflate(inflater, parent, false)
        return OverviewViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: OverviewViewHolder, position: Int) {
        holder.bindTo(students[position])
    }

}