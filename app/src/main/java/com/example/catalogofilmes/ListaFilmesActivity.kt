package com.example.catalogofilmes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaFilmesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_filmes)

        val recyclerFilmes = findViewById<RecyclerView>(R.id.recyclerFilmes)
        recyclerFilmes.layoutManager = LinearLayoutManager(this)
        recyclerFilmes.adapter = FilmeAdapter(FilmeRepository.filmes)
    }
}
