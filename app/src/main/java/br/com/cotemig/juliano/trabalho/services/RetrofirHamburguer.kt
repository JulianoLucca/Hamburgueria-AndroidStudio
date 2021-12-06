package br.com.cotemig.juliano.trabalho.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofirHamburguer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun serviceHamburguer(): ServiceHamburguer {
        return retrofit.create(ServiceHamburguer::class.java)
    }
}