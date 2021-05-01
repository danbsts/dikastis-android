package br.com.dikastis.app.problem

import android.R
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dikastis.app.databinding.ActivityProblemBinding
import br.com.dikastis.app.databinding.ActivityTaskBinding
import br.com.dikastis.app.model.Constants
import br.com.dikastis.app.overview.OverviewAdapter

class ProblemActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProblemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProblemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i("dale", "bora")
    }

}