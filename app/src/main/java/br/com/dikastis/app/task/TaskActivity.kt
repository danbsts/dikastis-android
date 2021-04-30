package br.com.dikastis.app.task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.dikastis.app.databinding.ActivityTaskBinding
import br.com.dikastis.app.model.Constants
import br.com.dikastis.app.overview.OverviewAdapter
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement


class TaskActivity : AppCompatActivity(){
    private lateinit var binding : ActivityTaskBinding

    val aaChartModel : AAChartModel = AAChartModel()
            .chartType(AAChartType.Bar)
            .title("Questões resolvidas")
            .subtitle("Numero de aceitos por aluno")
            .backgroundColor("#4b2b7f")
            .dataLabelsEnabled(true)
            .categories()
            .series(arrayOf(
                    AASeriesElement()
                            .name("Tokyo")
                            .data(arrayOf(1.0)),
                    AASeriesElement()
                            .name("NewYork")
                            .data(arrayOf(0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5)),
                    AASeriesElement()
                            .name("London")
                            .data(arrayOf(0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0)),
                    AASeriesElement()
                            .name("Berlin")
                            .data(arrayOf(3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8))
            )
            )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerViewTasks = binding.studentsList
        val chartView = binding.aaChartView
        recyclerViewTasks.apply {
            layoutManager = LinearLayoutManager(this@TaskActivity)
            addItemDecoration(DividerItemDecoration(this@TaskActivity, DividerItemDecoration.VERTICAL))
            adapter = OverviewAdapter(
                    Constants.students,
                    Constants.problems,
                    layoutInflater
            )
        }

        chartView.apply {
            aa_drawChartWithChartModel(aaChartModel)
        }

    }

}
