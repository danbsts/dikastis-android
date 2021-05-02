package br.com.dikastis.app.team

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.dikastis.app.dal.dao.DikastisAPIDao
import br.com.dikastis.app.model.Team

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