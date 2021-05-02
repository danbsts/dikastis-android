package br.com.dikastis.app.dal.dao

import br.com.dikastis.app.model.Organization
import br.com.dikastis.app.model.Task
import br.com.dikastis.app.model.Team
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIClient {

    @GET("/organizations")
    fun getOrganizations() : Call<List<Organization>>

    @GET("/organizations/{id}")
    fun getOrganization(@Path(value = "id") id: String) : Call<Organization>

    @GET("/teams/{id}")
    fun getTeam(@Path(value = "id") id: String) : Call<Team>

    @GET("/tasks/{id}")
    fun getTask(@Path(value = "id") id: String) : Call<Task>
}
