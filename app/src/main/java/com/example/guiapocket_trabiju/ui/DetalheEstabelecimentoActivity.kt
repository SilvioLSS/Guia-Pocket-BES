package com.example.guiapocket_trabiju.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.example.guiapocket_trabiju.databinding.ActivityDetalheEstabelecimentoBinding

class DetalheEstabelecimentoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalheEstabelecimentoBinding
    private var foto: Int = 0
    private lateinit var nome: String
    private lateinit var categoria: String
    private lateinit var descricao: String
    private lateinit var telefone: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalheEstabelecimentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
        setupViews()
        setupListeners()
    }

    private fun loadData() {
        foto = intent.getIntExtra("foto", 0)
        nome = intent.getStringExtra("nome") ?: ""
        categoria = intent.getStringExtra("categoria") ?: ""
        descricao = intent.getStringExtra("descricao") ?: ""
        telefone = intent.getStringExtra("telefone") ?: ""
    }

    private fun setupViews() {
        binding.imgEstabelecimento.setImageResource(foto)
        binding.nomeEstabelecimento.text = nome
        binding.categoriaEstabelecimento.text = categoria
        binding.descricaoEstabelecimento.text = descricao
    }

    private fun setupListeners() {
        binding.btnChamadaTelefonica.setOnClickListener {
            fazerLigacao()
        }
    }

    private fun fazerLigacao() {
        if (telefone.isNotEmpty()) {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = "tel:$telefone".toUri()
            startActivity(intent)
        } else {
            Toast.makeText(this, "Número de telefone inválido", Toast.LENGTH_SHORT).show()
        }

    }
}