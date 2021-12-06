package br.com.cotemig.juliano.trabalho.ul.activities


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.cotemig.juliano.Trabalho.services.RetrofitInitializer
import br.com.cotemig.juliano.trabalho.R
import br.com.cotemig.juliano.trabalho.models.Account
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var create = findViewById<Button>(R.id.create)
        create.setOnClickListener {
            createClick()
        }
    }

    fun createClick() {
        var name = findViewById<TextInputEditText>(R.id.name)
        var email = findViewById<TextInputEditText>(R.id.email)
        var password = findViewById<TextInputEditText>(R.id.password)

        var account = Account()
        account.name = name.text.toString()
        account.email = email.text.toString()
        account.password = password.text.toString()

        val s = RetrofitInitializer().serviceAccount()
        val call = s.register(account)

        call.enqueue(object : retrofit2.Callback<Account> {
            override fun onResponse(call: Call<Account>, response: Response<Account>) {
                if (response.code() == 200) {

                    var intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()

                }
            }

            override fun onFailure(call: Call<Account>, t: Throwable) {

            }
        })
    }
}