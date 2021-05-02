package br.com.dikastis.app.problem

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.dikastis.app.dal.dao.DikastisAPIDao
import br.com.dikastis.app.model.Problem
import br.com.dikastis.app.model.Submission
import br.com.dikastis.app.model.Task

class ProblemViewModel : ViewModel() {

    var submissions : MutableLiveData<List<Submission>> = MutableLiveData()
    private var dikastisApi = DikastisAPIDao()

    fun fetchSubmissions(problemId: String?, personId: String?) {
        if (problemId == null || personId == null) return
        dikastisApi.getSubmission(problemId, personId, ::updateSubmissions)
    }

    fun updateSubmissions(submissions: List<Submission>) {
        this.submissions.value = submissions
    }
}