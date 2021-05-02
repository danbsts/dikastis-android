package br.com.dikastis.app.overview

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.dikastis.app.R
import br.com.dikastis.app.databinding.ActivityOverviewBinding
import br.com.dikastis.app.model.Constants
import br.com.dikastis.app.model.Student
import br.com.dikastis.app.model.Submission
import br.com.dikastis.app.task.TaskViewModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement

class OverviewActivity : AppCompatActivity(){
    private lateinit var binding : ActivityOverviewBinding
    private val overviewViewModel: OverviewViewModel by viewModels()

    val aaChartModel : AAChartModel = AAChartModel()
        .chartType(AAChartType.Bar)
        .dataLabelsEnabled(true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overviewViewModel.fetchStudents()

        binding = ActivityOverviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var problems = intent.getStringArrayExtra("problems")!!

        overviewViewModel.students.observe(this@OverviewActivity, {
            if (it.isEmpty()) return@observe
            binding.aaChartView.apply {
                setNameAndValue(it.toTypedArray(), problems)
                aa_drawChartWithChartModel(aaChartModel)
            }
        })
    }

    fun setNameAndValue(students: Array<Student>, problems: Array<String>) {
        var accepted : Array<Int> = Array(problems.size) { 0 }
        var tried : Array<Int> = Array(accepted.size) { 0 }

        for (student : Student in students) {
            for(i in problems.indices) {
                var submited = 0
                var done = 0
                for(submission: Submission in student.submissions) {
                    if(submission.problemId == problems[i]) {
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
            .categories(problems.clone())
            .series(
                arrayOf(
                    AASeriesElement().name(getString(R.string.accepted)).data(acceptedResult),
                    AASeriesElement().name(getString(R.string.tried)).data(triedResult))
            )
    }
}