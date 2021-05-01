package br.com.dikastis.app.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.dikastis.app.databinding.StudentsBoxBinding
import br.com.dikastis.app.model.Student


class OverviewAdapter(
    private val students: Array<Student>,
    private val problems: ArrayAdapter<String>,
    private val inflater: LayoutInflater
) :
        RecyclerView.Adapter<OverviewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewViewHolder {
        val binding = StudentsBoxBinding.inflate(inflater, parent, false)
        return OverviewViewHolder(binding, problems)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: OverviewViewHolder, position: Int) {
        holder.bindTo(students[position])
    }

}