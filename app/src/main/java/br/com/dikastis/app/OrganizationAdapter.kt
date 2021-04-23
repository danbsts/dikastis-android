package br.com.dikastis.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.dikastis.app.databinding.OrganizationBoxBinding
import br.com.dikastis.app.model.Organization

class OrganizationAdapter (
        private val organizations: Array<Organization>,
        private val inflater: LayoutInflater) :
        RecyclerView.Adapter<OrganizationViewHolder>() {
    override fun getItemCount(): Int = organizations.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrganizationViewHolder {
        val binding = OrganizationBoxBinding.inflate(inflater, parent, false)
        return OrganizationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrganizationViewHolder, position: Int) {
        holder.bindTo(organizations[position])
    }
}
