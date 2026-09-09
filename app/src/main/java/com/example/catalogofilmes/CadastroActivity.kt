package com.example.catalogofilmes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val editTitulo = findViewById<EditText>(R.id.editTitulo)
        val editGenero = findViewById<EditText>(R.id.editGenero)
        val editPoster = findViewById<EditText>(R.id.editPoster)
        val botaoSalvar = findViewById<Button>(R.id.botaoSalvar)
        val textVerLista = findViewById<TextView>(R.id.textVerLista)

        botaoSalvar.setOnClickListener {
            val titulo = editTitulo.text.toString().trim()
            val genero = editGenero.text.toString().trim()
            val posterUrl = editPoster.text.toString().trim()

            if (titulo.isEmpty() || genero.isEmpty() || posterUrl.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                FilmeRepository.filmes.add(Filme(titulo, genero, posterUrl))
                Toast.makeText(this, "Filme salvo com sucesso!", Toast.LENGTH_SHORT).show()
                editTitulo.text.clear()
                editGenero.text.clear()
                editPoster.text.clear()
            }
        }

        textVerLista.setOnClickListener {
            startActivity(Intent(this, ListaFilmesActivity::class.java))
        }
    }
}
