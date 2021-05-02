package br.com.dikastis.app.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.dikastis.app.data.dao.DikastisAPIDao
import br.com.dikastis.app.data.model.Organization

class MainViewModel : ViewModel() {

    var organizations : MutableLiveData<List<Organization>> = MutableLiveData(listOf())
    private var dikastisApi = DikastisAPIDao()

    fun fetchOrganizations() {
        dikastisApi.getOrganizationsList(::updateOrganizations)
    }

    fun updateOrganizations(organizationsList: List<Organization>) {
        organizations.value = organizationsList
    }
}