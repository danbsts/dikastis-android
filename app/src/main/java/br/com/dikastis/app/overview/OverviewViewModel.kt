package br.com.dikastis.app.overview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.dikastis.app.dal.dao.DikastisAPIDao
import br.com.dikastis.app.model.Student
import br.com.dikastis.app.model.Submission

class OverviewViewModel : ViewModel() {

    var students : MutableLiveData<List<Student>> = MutableLiveData()
    private var dikastisApi = DikastisAPIDao()

    fun fetchStudents() {
        dikastisApi.getStudents(::updateStudents)
    }

    fun updateStudents(students: List<Student>) {
        this.students.value = students
    }
}