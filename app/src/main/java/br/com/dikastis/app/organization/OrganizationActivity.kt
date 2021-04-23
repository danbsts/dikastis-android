package br.com.dikastis.app.organization

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dikastis.app.OrganizationAdapter
import br.com.dikastis.app.databinding.ActivityOrganizationBinding
import br.com.dikastis.app.model.Constants

class OrganizationActivity : AppCompatActivity() {
    private lateinit var binding : ActivityOrganizationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrganizationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerViewTeams = binding.teamList
        val id = intent.getStringExtra("id")
        recyclerViewTeams.apply {
            layoutManager = LinearLayoutManager(this@OrganizationActivity)
            addItemDecoration(DividerItemDecoration(this@OrganizationActivity, DividerItemDecoration.VERTICAL))
            adapter = Constants.organizations.find { it.id == id }?.teams?.let { TeamAdapter(it,layoutInflater) }
        }

    }

}
