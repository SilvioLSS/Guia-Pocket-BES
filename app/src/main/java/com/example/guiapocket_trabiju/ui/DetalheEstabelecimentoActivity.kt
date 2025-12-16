package com.example.guiapocket_trabiju.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.example.guiapocket_trabiju.databinding.ActivityDetalheEstabelecimentoBinding
import com.example.guiapocket_trabiju.model.Estabelecimento

class DetalheEstabelecimentoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalheEstabelecimentoBinding
    private lateinit var estabelecimento: Estabelecimento

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalheEstabelecimentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
        setupViews()
        setupListeners()
    }

    private fun loadData() {
        estabelecimento =
            intent.getSerializableExtra("estabelecimento", Estabelecimento::class.java)
                    as Estabelecimento
    }

    private fun setupViews() {
        // Carregar imagem da URI ou do drawable
        if (estabelecimento.fotoUri != null) {
            binding.imgEstabelecimento.setImageURI(Uri.parse(estabelecimento.fotoUri))
        } else {
            binding.imgEstabelecimento.setImageResource(estabelecimento.foto)
        }

        binding.nomeEstabelecimento.text = estabelecimento.nome
        binding.categoriaEstabelecimento.text = estabelecimento.categoria
        binding.descricaoEstabelecimento.text = estabelecimento.descricao
    }

    private fun setupListeners() {
        binding.btnChamadaTelefonica.setOnClickListener {
            fazerLigacao()
        }
    }

    private fun fazerLigacao() {
        val telefone = estabelecimento.telefone
        if (telefone.isNotEmpty()) {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = "tel:$telefone".toUri()
            startActivity(intent)
        } else {
            Toast.makeText(this, "Número de telefone inválido", Toast.LENGTH_SHORT).show()
        }
    }
}