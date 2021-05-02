package br.com.dikastis.app.data.dao.config

import br.com.dikastis.app.data.dao.APIClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class RetrofitConfig {
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://dikastis-api.herokuapp.com")
        .addConverterFactory(JacksonConverterFactory.create())
        .build()

    fun getAPIInstance(): APIClient {
        return this.retrofit.create(APIClient::class.java)
    }
}
