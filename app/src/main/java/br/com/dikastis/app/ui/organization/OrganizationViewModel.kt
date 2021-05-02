package br.com.dikastis.app.ui.organization

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.dikastis.app.data.dao.DikastisAPIDao
import br.com.dikastis.app.data.model.Organization

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