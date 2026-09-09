package com.example.catalogofilmes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FilmeAdapter(
    private val filmes: MutableList<Filme>
) : RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder>() {

    class FilmeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagemPoster: ImageView = itemView.findViewById(R.id.imagemPoster)
        val textTitulo: TextView = itemView.findViewById(R.id.textTitulo)
        val textGenero: TextView = itemView.findViewById(R.id.textGenero)
        val botaoEditar: Button = itemView.findViewById(R.id.botaoEditar)
        val botaoExcluir: Button = itemView.findViewById(R.id.botaoExcluir)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filme, parent, false)
        return FilmeViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        val filme = filmes[position]
        holder.textTitulo.text = filme.titulo
        holder.textGenero.text = filme.genero

        Glide.with(holder.itemView.context)
            .load(filme.posterUrl)
            .into(holder.imagemPoster)

        holder.botaoEditar.setOnClickListener {
            // Botão apenas visual, conforme requisito.
        }

        holder.botaoExcluir.setOnClickListener {
            val posicaoAtual = holder.bindingAdapterPosition
            if (posicaoAtual != RecyclerView.NO_POSITION) {
                filmes.removeAt(posicaoAtual)
                notifyItemRemoved(posicaoAtual)
            }
        }
    }

    override fun getItemCount(): Int = filmes.size
}
