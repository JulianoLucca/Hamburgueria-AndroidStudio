package br.com.cotemig.juliano.trabalho.services

import br.com.cotemig.juliano.trabalho.models.Hamburguer
import retrofit2.Call
import retrofit2.http.GET

interface ServiceHamburguer{

    @GET("46d4000e-523e-4f6c-86c1-09cc403fb9ec")
    fun getHamburguer(): Call<List<Hamburguer>>

}