package com.example.guiapocket_trabiju.model

import java.io.Serializable

data class Estabelecimento(
    val foto: Int,
    val nome: String,
    val categoria: String,
    val descricao: String,
    val telefone: String
) : Serializable
