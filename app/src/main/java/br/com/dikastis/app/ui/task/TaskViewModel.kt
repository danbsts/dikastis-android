package br.com.dikastis.app.ui.task

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.dikastis.app.data.dao.DikastisAPIDao
import br.com.dikastis.app.data.model.Task

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