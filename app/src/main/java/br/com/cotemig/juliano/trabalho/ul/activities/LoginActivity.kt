package br.com.cotemig.juliano.trabalho.ul.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import br.com.cotemig.juliano.Trabalho.services.RetrofitInitializer
import br.com.cotemig.juliano.trabalho.R
import br.com.cotemig.juliano.trabalho.models.Account
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var login = findViewById<Button>(R.id.login)
        login.setOnClickListener {
            loginClick()
        }

    }

    fun loginClick() {

        var email = findViewById<TextInputEditText>(R.id.email)
        var password = findViewById<TextInputEditText>(R.id.password)

        var account = Account()
        account.email = email.text.toString()
        account.password = password.text.toString()

        val s = RetrofitInitializer().serviceAccount()
        val call = s.auth(account)

        call.enqueue(object : retrofit2.Callback<Account> {
            override fun onResponse(call: Call<Account>, response: Response<Account>) {
                if (response.code() == 200) {

                    response.body()?.let {
                        var intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.putExtra("account", it)
                        startActivity(intent)
                        finish()
                    }

                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Usuário ou senha inválidos",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<Account>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "Ops", Toast.LENGTH_LONG).show()
            }
        })


    }
}