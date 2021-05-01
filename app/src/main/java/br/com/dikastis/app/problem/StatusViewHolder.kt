package br.com.dikastis.app.problem

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import br.com.dikastis.app.R
import br.com.dikastis.app.databinding.StatusBoxBinding

class StatusViewHolder (private val binding: StatusBoxBinding):
    RecyclerView.ViewHolder(binding.root) {

    fun bindTo(status: String, submissionId : Int) {
        binding.status.text = status
        binding.submissionId.text = submissionId.toString()

        when (status) {
            "ACCEPTED" -> binding.icone.setImageResource(R.drawable.accepted_icon)
            "WA" -> binding.icone.setImageResource(R.drawable.wa_icon)
            "TLE" -> binding.icone.setImageResource(R.drawable.tle_icon)
            else -> binding.icone.setImageResource(R.drawable.rte_icon)
        }

        binding.root.setOnClickListener {
            val c = binding.status.context
            val intent = Intent()
            intent.action = "br.com.dikastis.submissionChange"
            intent.putExtra("submissionId", submissionId.toString())
            intent.flags = Intent.FLAG_INCLUDE_STOPPED_PACKAGES
            c.sendBroadcast(intent)
        }
    }
}