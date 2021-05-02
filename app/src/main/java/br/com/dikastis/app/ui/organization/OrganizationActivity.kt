package br.com.dikastis.app.ui.organization

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dikastis.app.databinding.ActivityOrganizationBinding
import br.com.dikastis.app.ui.team.adapter.TeamAdapter

class OrganizationActivity : AppCompatActivity() {
    private lateinit var binding : ActivityOrganizationBinding
    private val organizationViewModel: OrganizationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrganizationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val organizationId = intent.getStringExtra("id")
        val organizationName = intent.getStringExtra("name")
        binding.organizationName.text = organizationName

        val recyclerViewTeams = binding.teamList
        organizationViewModel.fetchOrganization(organizationId)
        recyclerViewTeams.apply {
            layoutManager = LinearLayoutManager(this@OrganizationActivity)
            addItemDecoration(DividerItemDecoration(this@OrganizationActivity, DividerItemDecoration.VERTICAL))
            organizationViewModel.organization.observe(this@OrganizationActivity, {
                adapter = it.teams.let {
                    TeamAdapter(
                        it,
                        layoutInflater
                    )
                }
            })
        }
    }

}
