package br.com.dikastis.app.ui.problem

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.dikastis.app.data.dao.DikastisAPIDao
import br.com.dikastis.app.data.model.Submission

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