package com.example.guiapocket_trabiju.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.guiapocket_trabiju.R
import com.example.guiapocket_trabiju.adapter.EstabelecimentoAdapter
import com.example.guiapocket_trabiju.databinding.ActivityMainBinding
import com.example.guiapocket_trabiju.model.Estabelecimento
import com.example.guiapocket_trabiju.ui.DetalheEstabelecimentoActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var estabelecimentos: MutableList<Estabelecimento>
    private lateinit var adapter: EstabelecimentoAdapter
    private lateinit var launcherCadastro: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        estabelecimentos = mutableListOf()
        loadData()
        setupRecyclerView()
        setupLauncherCadastro()
        setupListeners()
    }

    private fun loadData() {
        estabelecimentos.addAll(
            listOf(
                Estabelecimento(R.drawable.imgsbes, "SBES", "Supermercado", "Descrição...", "999999"),
                Estabelecimento(R.drawable.img_belopao, "Belo Pão", "Padaria", "Descrição...", "888888")
            )
        )
    }

    private fun setupRecyclerView() {
        adapter = EstabelecimentoAdapter(estabelecimentos) { estabelecimento ->
            val intent = Intent(this, DetalheEstabelecimentoActivity::class.java)
            intent.putExtra("estabelecimento", estabelecimento)
            startActivity(intent)
        }

        binding.recyclerViewEstabelecimentos.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
        }
    }

    private fun setupLauncherCadastro() {
        launcherCadastro = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val novo = result.data
                    ?.getSerializableExtra("estabelecimento", Estabelecimento::class.java)

                if (novo != null) {
                    estabelecimentos.add(novo)
                    adapter.notifyItemInserted(estabelecimentos.size - 1)
                }
            }
        }
    }

    private fun setupListeners() {
        binding.btnAdicionar.setOnClickListener {
            launcherCadastro.launch(
                Intent(this, CadastroEstabelecimentoActivity::class.java)
            )
        }
    }
}
