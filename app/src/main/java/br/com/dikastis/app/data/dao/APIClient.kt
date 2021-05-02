package br.com.dikastis.app.data.dao

import br.com.dikastis.app.data.model.*
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

    @GET("submissions/{problemId}/{personId}")
    fun getSubmissions(@Path(value = "problemId") problemId: String, @Path(value = "personId") personId: String) : Call<List<Submission>>

    @GET("/students")
    fun getStudents() : Call<List<Student>>
}
