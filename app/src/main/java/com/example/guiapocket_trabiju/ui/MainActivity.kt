package com.example.guiapocket_trabiju.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.guiapocket_trabiju.adapter.EstabelecimentoAdapter
import com.example.guiapocket_trabiju.data.EstabelecimentoRepository
import com.example.guiapocket_trabiju.databinding.ActivityMainBinding
import com.example.guiapocket_trabiju.model.Estabelecimento

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var estabelecimentos: MutableList<Estabelecimento>
    private lateinit var estabelecimentosFiltrados: MutableList<Estabelecimento>
    private lateinit var adapter: EstabelecimentoAdapter
    private lateinit var launcherCadastro: ActivityResultLauncher<Intent>
    private lateinit var repository: EstabelecimentoRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repository = EstabelecimentoRepository(this)
        estabelecimentos = mutableListOf()
        estabelecimentosFiltrados = mutableListOf()

        setupRecyclerView()
        setupLauncherCadastro()
        setupListeners()
        setupFiltro()
        carregarEstabelecimentos()
    }

    private fun carregarEstabelecimentos() {
        repository.listarTodos { lista ->
            runOnUiThread {
                estabelecimentos.clear()
                estabelecimentos.addAll(lista)
                filtrarEstabelecimentos(binding.edtFiltro.text.toString())
            }
        }
    }

    private fun setupRecyclerView() {
        adapter = EstabelecimentoAdapter(estabelecimentosFiltrados) { estabelecimento ->
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

    private fun setupFiltro() {
        binding.edtFiltro.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filtrarEstabelecimentos(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun filtrarEstabelecimentos(texto: String) {
        estabelecimentosFiltrados.clear()

        if (texto.isEmpty()) {
            estabelecimentosFiltrados.addAll(estabelecimentos)
        } else {
            val filtro = texto.lowercase()
            estabelecimentosFiltrados.addAll(
                estabelecimentos.filter {
                    it.nome.lowercase().contains(filtro)
                }
            )
        }

        adapter.updateLista(estabelecimentosFiltrados)
    }

    private fun setupLauncherCadastro() {
        launcherCadastro = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // Recarregar a lista do banco
                carregarEstabelecimentos()
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