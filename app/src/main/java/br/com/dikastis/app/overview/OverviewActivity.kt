package br.com.dikastis.app.overview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dikastis.app.databinding.ActivityOrganizationBinding
import br.com.dikastis.app.databinding.ActivityOverviewBinding
import br.com.dikastis.app.databinding.ActivityTaskBinding
import br.com.dikastis.app.model.Constants

class OverviewActivity : AppCompatActivity(){
    private lateinit var binding : ActivityOverviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("Chegamos aqui")
    }
}