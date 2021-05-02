package br.com.dikastis.app.dal.dao.config

import br.com.dikastis.app.dal.dao.APIClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class RetrofitConfig {
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.105:3000")
        .addConverterFactory(JacksonConverterFactory.create())
        .build()

    fun getAPIInstance(): APIClient {
        return this.retrofit.create(APIClient::class.java)
    }
}
