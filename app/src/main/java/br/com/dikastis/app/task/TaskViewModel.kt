package br.com.dikastis.app.task

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.dikastis.app.dal.dao.DikastisAPIDao
import br.com.dikastis.app.model.Organization
import br.com.dikastis.app.model.Task
import br.com.dikastis.app.model.Team

class TaskViewModel : ViewModel() {

    var task : MutableLiveData<Task> = MutableLiveData()
    private var dikastisApi = DikastisAPIDao()

    fun fetchTask(id: String?) {
        if (id == null) return
        dikastisApi.getTask(id, ::updateTasks)
    }

    fun updateTasks(task: Task) {
        this.task.value = task
    }
}