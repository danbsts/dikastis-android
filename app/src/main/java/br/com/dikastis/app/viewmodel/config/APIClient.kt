package br.com.dikastis.app.viewmodel.config

import br.com.dikastis.app.model.Organization
import retrofit2.Call
import retrofit2.http.GET

interface APIClient {

    @GET("/organizations")
    fun getOrganizations() : Call<Organization>
}
