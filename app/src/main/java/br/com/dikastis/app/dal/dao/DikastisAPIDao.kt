package br.com.dikastis.app.dal.dao

import br.com.dikastis.app.model.Organization
import br.com.dikastis.app.dal.dao.config.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DikastisAPIDao {

    private val api = RetrofitConfig().getAPIInstance()

    fun getOrganizationsList(updateOrganizations: (organizationList: List<Organization>) -> Unit) {
        api.getOrganizations().enqueue(object : Callback<List<Organization>?> {
            override fun onResponse(call: Call<List<Organization>?>?, response: Response<List<Organization>?>?) {
                val organizationList: List<Organization>? = response!!.body()
                if (organizationList != null) {
                    return updateOrganizations(organizationList)
                }
            }

            override fun onFailure(call: Call<List<Organization>?>, t: Throwable) {
                throw t
            }
        })
    }

    fun getOrganization(id: String, updateOrganization: (organization: Organization) -> Unit) {
        api.getOrganization(id).enqueue(object : Callback<Organization?> {
            override fun onResponse(call: Call<Organization?>?, response: Response<Organization?>?) {
                val orgnaization: Organization? = response!!.body()
                if (orgnaization != null) {
                    return updateOrganization(orgnaization)
                }
            }

            override fun onFailure(call: Call<Organization?>, t: Throwable) {
                throw t
            }
        })
    }
}