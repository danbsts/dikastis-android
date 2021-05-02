package br.com.dikastis.app.ui.overview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.dikastis.app.data.dao.DikastisAPIDao
import br.com.dikastis.app.data.model.Student

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