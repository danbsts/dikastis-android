package br.com.dikastis.app.dal.dao

import br.com.dikastis.app.model.Organization
import retrofit2.Call
import retrofit2.http.GET

interface APIClient {

    @GET("/organizations")
    fun getOrganizations() : Call<List<Organization>>
}
