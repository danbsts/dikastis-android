package br.com.dikastis.app

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import br.com.dikastis.app.databinding.OrganizationBoxBinding
import br.com.dikastis.app.model.Organization
import br.com.dikastis.app.organization.OrganizationActivity

class OrganizationViewHolder(private val binding: OrganizationBoxBinding):
    RecyclerView.ViewHolder(binding.root) {

    fun bindTo(organization : Organization) {
        binding.name.text = organization.name
        binding.root.setOnClickListener {
            val c = binding.name.context
            val intentExplicito = Intent(c, OrganizationActivity::class.java)
            intentExplicito.putExtra("id", organization.id)
            c.startActivity(intentExplicito)
        }
        "${organization.groupsCount} groups".also { binding.gorupCount.text = it }
        "${organization.membersCount} members".also { binding.membersCount.text = it }
        "${organization.adminsCount} admins".also { binding.adminsCount.text = it }
    }
}
