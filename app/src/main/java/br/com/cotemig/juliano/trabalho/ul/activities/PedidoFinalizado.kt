package br.com.cotemig.juliano.trabalho.ul.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import br.com.cotemig.juliano.trabalho.R

class PedidoFinalizado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido_finalizado)

        var voltar = findViewById<Button>(R.id.voltar)
        voltar.setOnClickListener {
            finish()

        }

    }
}


