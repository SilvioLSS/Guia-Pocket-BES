package com.example.guiapocket_trabiju.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.guiapocket_trabiju.R
import com.example.guiapocket_trabiju.adapter.EstabelecimentoAdapter
import com.example.guiapocket_trabiju.databinding.ActivityMainBinding
import com.example.guiapocket_trabiju.model.Estabelecimento

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var estabelecimentos: List<Estabelecimento>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
        setupViews()
        setupListeners()
    }

    private fun loadData() {
        estabelecimentos = listOf(
            Estabelecimento(R.drawable.imgsbes, getString(R.string.nome_sbes), getString(R.string.supermercado), getString(R.string.desc_sbes), getString(R.string.telefone_sbes)),
            Estabelecimento(R.drawable.img_belopao, getString(R.string.nome_beloPao), getString(R.string.padaria), getString(R.string.desc_beloPao), getString(R.string.telefone_beloPao)),
            Estabelecimento(R.drawable.img_academia, getString(R.string.nome_academia), getString(R.string.academia), getString(R.string.desc_academia), getString(R.string.telefone_academia)),
            Estabelecimento(R.drawable.img_aquaflora, getString(R.string.nome_aquaflora), getString(R.string.agropecuaria), getString(R.string.desc_aquaflora), getString(R.string.telefone_aquaflora)),
            Estabelecimento(R.drawable.img_tradicao, getString(R.string.nome_tradicao), getString(R.string.choperia), getString(R.string.desc_tradicao), getString(R.string.telefone_tradicao)),
            Estabelecimento(R.drawable.img_ivani, getString(R.string.nome_ivani), getString(R.string.loja_de_roupa), getString(R.string.desc_ivani), getString(R.string.telefone_ivani))
        )
    }

    private fun setupViews() {
        val adapter = EstabelecimentoAdapter(this, estabelecimentos)
        binding.listViewEstabelecimentos.adapter = adapter
    }

    private fun setupListeners() {
        binding.listViewEstabelecimentos.setOnItemClickListener { _, _, position, _ ->
            val estabelecimento = estabelecimentos[position]
            val intent = Intent(this, DetalheEstabelecimentoActivity::class.java)

            intent.putExtra("foto", estabelecimento.foto)
            intent.putExtra("nome", estabelecimento.nome)
            intent.putExtra("categoria", estabelecimento.categoria)
            intent.putExtra("descricao", estabelecimento.descricao)
            intent.putExtra("telefone", estabelecimento.telefone)

            startActivity(intent)
        }
    }
}