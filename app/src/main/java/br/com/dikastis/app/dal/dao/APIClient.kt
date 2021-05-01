package br.com.dikastis.app.dal.dao

import br.com.dikastis.app.model.Organization
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIClient {

    @GET("/organizations")
    fun getOrganizations() : Call<List<Organization>>

    @GET("/organizations/{id}")
    fun getOrganization(@Path(value = "id") id: String) : Call<Organization>
}
