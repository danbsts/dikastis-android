package br.com.dikastis.app.organization

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.dikastis.app.dal.dao.DikastisAPIDao
import br.com.dikastis.app.model.Organization

class OrganizationViewModel : ViewModel() {

    var organization : MutableLiveData<Organization> = MutableLiveData()
    private var dikastisApi = DikastisAPIDao()

    fun fetchOrganization(id: String?) {
        if (id == null) return
        dikastisApi.getOrganization(id, ::updateOrganizations)
    }

    fun updateOrganizations(organization: Organization) {
        this.organization.value = organization
    }
}