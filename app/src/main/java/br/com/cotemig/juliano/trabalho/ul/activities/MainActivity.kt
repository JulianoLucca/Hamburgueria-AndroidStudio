package br.com.cotemig.juliano.trabalho.ul.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.juliano.trabalho.R
import br.com.cotemig.juliano.trabalho.adapters.CardapioAdapter
import br.com.cotemig.juliano.trabalho.models.Account
import br.com.cotemig.juliano.trabalho.models.Hamburguer
import br.com.cotemig.juliano.trabalho.services.RetrofirHamburguer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var account = intent.getSerializableExtra("account") as Account

        var welcome = findViewById<TextView>(R.id.welcome)
        welcome.text = resources.getString(R.string.main_welcomemessage, account.name)

        getCardapio()
    }

    fun getCardapio(){

        val s = RetrofirHamburguer().serviceHamburguer()
        val call = s.getHamburguer()

        call.enqueue(object: Callback<List<Hamburguer>>{

            override fun onResponse(call: Call<List<Hamburguer>>, response: Response<List<Hamburguer>>
            ) {
               if(response.code()==200){
                   response.body()?.let{
                       list ->
                       showHamburguer(list)

                   }
               }
            }

            override fun onFailure(call: Call<List<Hamburguer>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Ops", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun showHamburguer(list: List<Hamburguer>){

        var item = findViewById<RecyclerView>(R.id.item)
        item.adapter = CardapioAdapter(this, list){
            hamburguer ->
            var intent = Intent(this, DescricaoActivity::class.java)
            intent.putExtra("nome", hamburguer.nome)
            intent.putExtra("valor", hamburguer.valor)
            intent.putExtra("descicao", hamburguer.descicao)
            intent.putExtra("picture", hamburguer.picture)
            startActivity(intent)
        }


        item.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }



}