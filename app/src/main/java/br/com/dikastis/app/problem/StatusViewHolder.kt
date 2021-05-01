package br.com.dikastis.app.problem

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import br.com.dikastis.app.databinding.StatusBoxBinding

class StatusViewHolder (private val binding: StatusBoxBinding):
    RecyclerView.ViewHolder(binding.root) {

    fun bindTo(status: String, submissionId : Int) {
        binding.status.text = status
        binding.submissionId.text = submissionId.toString()

        binding.root.setOnClickListener {
            val c = binding.status.context
            val intentExplicito = Intent(c, ProblemActivity::class.java)
            intentExplicito.putExtra("submissionId", submissionId)
            c.startActivity(intentExplicito)
        }
    }
}