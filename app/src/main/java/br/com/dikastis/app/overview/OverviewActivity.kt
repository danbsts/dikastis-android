package br.com.dikastis.app.overview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.dikastis.app.R
import br.com.dikastis.app.databinding.ActivityOverviewBinding
import br.com.dikastis.app.model.Constants
import br.com.dikastis.app.model.Problem
import br.com.dikastis.app.model.Student
import br.com.dikastis.app.model.Submission
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement

class OverviewActivity : AppCompatActivity(){
    private lateinit var binding : ActivityOverviewBinding

    val aaChartModel : AAChartModel = AAChartModel()
        .chartType(AAChartType.Bar)
        .dataLabelsEnabled(true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOverviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val chartView = binding.aaChartView
        chartView.apply {
            setNameAndValue(Constants.students, Constants.problems)
            aa_drawChartWithChartModel(aaChartModel)
        }
    }

    fun setNameAndValue(students: Array<Student>, problems: Array<Problem>) {
        var nomes : Array<String> = problems.map { problem -> problem.name }.toTypedArray()
        var accepted : Array<Int> = Array(nomes.size) { 0 }
        var tried : Array<Int> = Array(accepted.size) { 0 }

        for (student : Student in students) {
            for(i in nomes.indices) {
                var submited = 0
                var done = 0
                println(nomes[i])
                for(submission: Submission in student.submissions) {
                    if(submission.problemId == nomes[i]) {
                        submited = 1
                        if(submission.status == "ACCEPTED") {
                            done = 1
                        }
                    }
                }
                accepted[i] = accepted[i].plus(done)
                tried[i] = tried[i].plus(submited)
            }
        }

        var acceptedResult : Array<Any>  = accepted.map { i -> i }.toTypedArray()
        var triedResult : Array<Any>  = tried.map { i -> i }.toTypedArray()

        aaChartModel
            .title(getString(R.string.chart_title))
            .subtitle(getString(R.string.chart_description))
            .categories(nomes.clone())
            .series(
                arrayOf(
                    AASeriesElement().name(getString(R.string.accepted)).data(acceptedResult),
                    AASeriesElement().name(getString(R.string.tried)).data(triedResult))
            )
    }
}