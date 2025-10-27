package com.example.guiapocket_trabiju.ui

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
    }

    private fun loadData() {
        estabelecimentos = listOf(
            Estabelecimento(R.drawable.imgsbes, "Boa Esperança Serve", getString(R.string.supermercado)),
            Estabelecimento(R.drawable.img_belopao, "Belo Pão", getString(R.string.padaria)),
            Estabelecimento(R.drawable.img_academia, "Vip Fitness", getString(R.string.academia)),
            Estabelecimento(R.drawable.img_aquaflora, "Aquaflora", getString(R.string.agropecuaria)),
            Estabelecimento(R.drawable.img_tradicao, "Tradição", getString(R.string.choperia)),
            Estabelecimento(R.drawable.img_ivani, "Ivani Modas", getString(R.string.loja_de_roupa))

        )
    }

    private fun setupViews() {
        val adapter = EstabelecimentoAdapter(this, estabelecimentos)
        binding.listViewEstabelecimentos.adapter = adapter
    }

}