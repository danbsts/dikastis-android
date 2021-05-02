package br.com.dikastis.app.organization

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dikastis.app.databinding.ActivityOrganizationBinding
import br.com.dikastis.app.model.Constants
import br.com.dikastis.app.team.TeamAdapter

class OrganizationActivity : AppCompatActivity() {
    private lateinit var binding : ActivityOrganizationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrganizationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val organizationId = intent.getStringExtra("id")
        val organizationName = intent.getStringExtra("name")
        binding.organizationName.text = organizationName

        val recyclerViewTeams = binding.teamList
        recyclerViewTeams.apply {
            layoutManager = LinearLayoutManager(this@OrganizationActivity)
            addItemDecoration(DividerItemDecoration(this@OrganizationActivity, DividerItemDecoration.VERTICAL))
            adapter = Constants.organizations.find { it.id == organizationId }?.teams?.let {
                TeamAdapter(
                    it,
                    layoutInflater
                )
            }
        }

    }

}
