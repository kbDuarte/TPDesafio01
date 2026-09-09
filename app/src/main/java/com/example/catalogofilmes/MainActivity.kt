package com.example.catalogofilmes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editUsuario = findViewById<EditText>(R.id.editUsuario)
        val editSenha = findViewById<EditText>(R.id.editSenha)
        val botaoEntrar = findViewById<Button>(R.id.botaoEntrar)

        botaoEntrar.setOnClickListener {
            val usuario = editUsuario.text.toString()
            val senha = editSenha.text.toString()

            if (usuario == "admin" && senha == "1234") {
                startActivity(Intent(this, CadastroActivity::class.java))
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
