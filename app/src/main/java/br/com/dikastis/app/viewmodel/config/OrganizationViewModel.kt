package br.com.dikastis.app.viewmodel.config

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.dikastis.app.dal.dao.DikastisAPIDao
import br.com.dikastis.app.model.Organization

class OrganizationViewModel : ViewModel() {

    var organizations : MutableLiveData<List<Organization>> = MutableLiveData(listOf())
    private var dikastisApi = DikastisAPIDao()

    fun fetchOrganizations() {
        dikastisApi.getOrganizationsList(::updateOrganizations)
    }

    fun updateOrganizations(organizationsList: List<Organization>) {
        organizations.value = organizationsList
    }
}