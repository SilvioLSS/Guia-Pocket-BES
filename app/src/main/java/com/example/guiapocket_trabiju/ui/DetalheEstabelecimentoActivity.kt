package com.example.guiapocket_trabiju.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.guiapocket_trabiju.databinding.ActivityDetalheEstabelecimentoBinding

class DetalheEstabelecimentoActivity : AppCompatActivity(){

    private lateinit var binding: ActivityDetalheEstabelecimentoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalheEstabelecimentoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}