package br.com.dikastis.app.organization

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dikastis.app.MainViewModel
import br.com.dikastis.app.databinding.ActivityOrganizationBinding
import br.com.dikastis.app.model.Constants
import br.com.dikastis.app.team.TeamAdapter

class OrganizationActivity : AppCompatActivity() {
    private lateinit var binding : ActivityOrganizationBinding
    private val organizationViewModel: OrganizationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrganizationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerViewTeams = binding.teamList
        val id = intent.getStringExtra("id")
        organizationViewModel.fetchOrganization(id)
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
