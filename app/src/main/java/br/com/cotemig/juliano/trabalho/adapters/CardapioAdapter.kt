package br.com.cotemig.juliano.trabalho.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.juliano.trabalho.R
import br.com.cotemig.juliano.trabalho.models.Hamburguer
import coil.load

class CardapioAdapter  (var context: Context, var list: List<Hamburguer>, var onClickCard: (Hamburguer) -> Unit ) : RecyclerView.Adapter<CardapioAdapter.HamburguerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardapioAdapter.HamburguerHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_cardapio, parent, false   )
        return HamburguerHolder(view)
    }

    override fun onBindViewHolder(holder: CardapioAdapter.HamburguerHolder, position: Int) {
        holder.bind(list[position], onClickCard)
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    class HamburguerHolder ( var view: View) : RecyclerView.ViewHolder(view){

        fun bind(hamburguer: Hamburguer, onClickCard: (Hamburguer) -> Unit){

            var name = view.findViewById<TextView>(R.id.name)
            name.text = hamburguer.nome

            var valor = view.findViewById<TextView>(R.id.valor)
            valor.text = hamburguer.valor

            var picture = view.findViewById<ImageView>(R.id.picture)
            picture.load(hamburguer.picture)

            var card = view.findViewById<CardView>(R.id.card)
            card.setOnClickListener {
                onClickCard(hamburguer)
            }

        }
    }
}