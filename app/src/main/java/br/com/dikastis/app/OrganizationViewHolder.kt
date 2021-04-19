package br.com.dikastis.app

import android.content.Intent
import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import br.com.dikastis.app.databinding.LinhaBinding

class OrganizationViewHolder(private val binding: LinhaBinding):
    RecyclerView.ViewHolder(binding.root) {
    var name : String = "algum nome"
    var groupsCount : Int = 1
    var adminsCount : Int = 1
    var memebersCount : Int = 1

    init {
//        binding.root.setOnClickListener {
//            val c = binding.nome.context

            //Intent Explicito
//            val intentExplicito = Intent(c, ProfessorActivity::class.java)
//            intentExplicito.putExtra("nome", name)
//            intentExplicito.putExtra("login", groupsCount)
            //c.startActivity(intentExplicito)

//            val intentImplicito = Intent()
//            intentImplicito.action = Intent.ACTION_VIEW
//            intentImplicito.data = Uri.parse(memebersCount)//https://

            //intentImplicito.data = Uri.parse("geo:0,0?q=Marco Zero")

//            c.startActivity(intentImplicito)
//        }
    }

    fun bindTo(organization : Organization) {
        name = organization.name
        groupsCount = organization.groupsCount
        memebersCount = organization.membersCount
        adminsCount = organization.adminsCount

        binding.name.text = organization.name
        "${organization.groupsCount} groups".also { binding.gorupCount.text = it }
        "${organization.membersCount} members".also { binding.membersCount.text = it }
        "${organization.adminsCount} admins".also { binding.adminsCount.text = it }
    }
}
