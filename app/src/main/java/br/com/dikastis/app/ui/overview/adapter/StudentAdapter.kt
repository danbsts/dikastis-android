package br.com.dikastis.app.ui.overview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.dikastis.app.databinding.StudentsBoxBinding
import br.com.dikastis.app.data.model.Student


class StudentAdapter(
    private val students: Array<Student>,
    private val problems: ArrayAdapter<String>,
    private val inflater: LayoutInflater
) :
        RecyclerView.Adapter<StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = StudentsBoxBinding.inflate(inflater, parent, false)
        return StudentViewHolder(binding, problems)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bindTo(students[position])
    }

}