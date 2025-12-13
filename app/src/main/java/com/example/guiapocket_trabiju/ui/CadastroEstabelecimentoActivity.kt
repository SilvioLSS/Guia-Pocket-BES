package com.example.guiapocket_trabiju.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.guiapocket_trabiju.R
import com.example.guiapocket_trabiju.databinding.ActivityCadastroEstabelecimentoBinding
import com.example.guiapocket_trabiju.model.Estabelecimento

class CadastroEstabelecimentoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroEstabelecimentoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroEstabelecimentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.btnSalvar.setOnClickListener {
            val nome = binding.edtNome.text.toString()
            val categoria = binding.edtCategoria.text.toString()
            val descricao = binding.edtDescricao.text.toString()
            val telefone = binding.edtTelefone.text.toString()

            if (nome.isNotBlank() && categoria.isNotBlank()) {
                val estabelecimento = Estabelecimento(
                    foto = R.drawable.img_padrao,
                    nome = nome,
                    categoria = categoria,
                    descricao = descricao,
                    telefone = telefone
                )

                val result = Intent().apply {
                    putExtra("estabelecimento", estabelecimento)
                }

                setResult(Activity.RESULT_OK, result)
                finish()
            }
        }

        binding.btnVoltar.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}
