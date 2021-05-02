package br.com.dikastis.app.ui.team

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.dikastis.app.data.dao.DikastisAPIDao
import br.com.dikastis.app.data.model.Team

class TeamViewModel : ViewModel() {

    var team : MutableLiveData<Team> = MutableLiveData()
    private var dikastisApi = DikastisAPIDao()

    fun fetchTeam(id: String?) {
        if (id == null) return
        dikastisApi.getTeam(id, ::updateTeams)
    }

    fun updateTeams(team: Team) {
        this.team.value = team
    }
}