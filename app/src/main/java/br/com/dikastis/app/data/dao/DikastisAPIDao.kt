package br.com.dikastis.app.data.dao

import br.com.dikastis.app.data.dao.config.RetrofitConfig
import br.com.dikastis.app.data.model.*
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

    fun getTeam(id: String, updateTeam: (team: Team) -> Unit) {
        api.getTeam(id).enqueue(object : Callback<Team?> {
            override fun onResponse(call: Call<Team?>?, response: Response<Team?>?) {
                val team: Team? = response!!.body()
                if (team != null) {
                    return updateTeam(team)
                }
            }

            override fun onFailure(call: Call<Team?>, t: Throwable) {
                throw t
            }
        })
    }

    fun getTask(id: String, updateTask: (task: Task) -> Unit) {
        api.getTask(id).enqueue(object : Callback<Task?> {
            override fun onResponse(call: Call<Task?>?, response: Response<Task?>?) {
                val task: Task? = response!!.body()
                if (task != null) {
                    return updateTask(task)
                }
            }

            override fun onFailure(call: Call<Task?>, t: Throwable) {
                throw t
            }
        })
    }

    fun getSubmission(problemId: String, personId: String, updateSubmission: (submissions: List<Submission>) -> Unit) {
        api.getSubmissions(problemId, personId).enqueue(object : Callback<List<Submission>?> {
            override fun onResponse(call: Call<List<Submission>?>?, response: Response<List<Submission>?>?) {
                val submissions: List<Submission>? = response!!.body()
                if (submissions != null) {
                    updateSubmission(submissions)
                }
            }

            override fun onFailure(call: Call<List<Submission>?>, t: Throwable) {
                throw t
            }
        })
    }

    fun getStudents(updateStudents: (students: List<Student>) -> Unit) {
        api.getStudents().enqueue(object : Callback<List<Student>?> {
            override fun onResponse(call: Call<List<Student>?>?, response: Response<List<Student>?>?) {
                val students: List<Student>? = response!!.body()
                if (students != null) {
                    updateStudents(students)
                }
            }

            override fun onFailure(call: Call<List<Student>?>, t: Throwable) {
                throw t
            }
        })
    }
}