package br.com.cotemig.juliano.Trabalho.services



import br.com.cotemig.juliano.trabalho.models.Account
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ServiceAccount {

    @POST("account/auth")
    fun auth(@Body account: Account): Call<Account>

    @POST("account")
    fun register(@Body account: Account): Call<Account>

}