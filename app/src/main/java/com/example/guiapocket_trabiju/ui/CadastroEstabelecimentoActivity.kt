package com.example.guiapocket_trabiju.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.guiapocket_trabiju.R
import com.example.guiapocket_trabiju.data.EstabelecimentoRepository
import com.example.guiapocket_trabiju.databinding.ActivityCadastroEstabelecimentoBinding
import com.example.guiapocket_trabiju.model.Estabelecimento

class CadastroEstabelecimentoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroEstabelecimentoBinding
    private lateinit var repository: EstabelecimentoRepository
    private var imagemSelecionadaUri: Uri? = null
    private lateinit var imagePickerLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroEstabelecimentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repository = EstabelecimentoRepository(this)

        setupImagePicker()
        setupListeners()
    }

    private fun setupImagePicker() {
        imagePickerLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val uri = result.data?.data
                if (uri != null) {
                    imagemSelecionadaUri = uri

                    // Dar permissão persistente para acessar a URI
                    contentResolver.takePersistableUriPermission(
                        uri,
                        Intent.FLAG_GRANT_READ_URI_PERMISSION
                    )

                    // Mostrar preview da imagem
                    binding.imgPreview.setImageURI(uri)
                    Toast.makeText(this, "Imagem selecionada!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setupListeners() {
        binding.btnSelecionarImagem.setOnClickListener {
            abrirGaleria()
        }

        binding.btnSalvar.setOnClickListener {
            salvarEstabelecimento()
        }

        binding.btnVoltar.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }

    private fun abrirGaleria() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "image/*"
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION)
        }
        imagePickerLauncher.launch(intent)
    }

    private fun salvarEstabelecimento() {
        val nome = binding.edtNome.text.toString()
        val categoria = binding.edtCategoria.text.toString()
        val descricao = binding.edtDescricao.text.toString()
        val telefone = binding.edtTelefone.text.toString()

        if (nome.isBlank() || categoria.isBlank()) {
            Toast.makeText(
                this,
                "Por favor, preencha nome e categoria",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val estabelecimento = Estabelecimento(
            foto = if (imagemSelecionadaUri == null) R.drawable.img_padrao else 0,
            fotoUri = imagemSelecionadaUri?.toString(),
            nome = nome,
            categoria = categoria,
            descricao = descricao,
            telefone = telefone
        )

        // Salvar no banco de dados
        repository.inserir(estabelecimento) { id ->
            runOnUiThread {
                Toast.makeText(
                    this,
                    "Estabelecimento salvo com sucesso!",
                    Toast.LENGTH_SHORT
                ).show()

                setResult(Activity.RESULT_OK)
                finish()
            }
        }
    }
}