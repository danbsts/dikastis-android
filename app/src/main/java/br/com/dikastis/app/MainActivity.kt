package br.com.dikastis.app

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dikastis.app.databinding.ActivityMainBinding
import br.com.dikastis.app.model.Constants
import br.com.dikastis.app.model.Organization
import br.com.dikastis.app.organization.OrganizationAdapter
import br.com.dikastis.app.viewmodel.config.RetrofitConfig
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerViewOrganizations = binding.contentMain.organizationList

        recyclerViewOrganizations.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = OrganizationAdapter(Constants.organizations, layoutInflater)
        }

        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val call: Call<Organization> =
            RetrofitConfig().getOrganizationService().getOrganizations()
        call.enqueue(object : Callback<Organization?> {
            override fun onResponse(
                call: Call<Organization?>?,
                response: Response<Organization?>?
            ) {
                val cep: Organization? = response!!.body()
                Log.i("AQUIIIIIIIIIIIII", cep.toString())
            }

            override fun onFailure(call: Call<Organization?>, t: Throwable) {
                Log.e("DEU RUIM", t.message.toString())
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}