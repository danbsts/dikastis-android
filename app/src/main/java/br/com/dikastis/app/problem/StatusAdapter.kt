package br.com.dikastis.app.problem

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dikastis.app.databinding.StatusBoxBinding
import br.com.dikastis.app.model.Submission

class StatusAdapter (
    private val submissions: Array<Submission>,
    private val inflater: LayoutInflater
) :
    RecyclerView.Adapter<StatusViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusViewHolder {
        val binding = StatusBoxBinding.inflate(inflater, parent, false)
        return StatusViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StatusViewHolder, position: Int) {
        holder.bindTo(submissions[position].status, position + 1)
    }

    override fun getItemCount(): Int {
        return submissions.size
    }

}