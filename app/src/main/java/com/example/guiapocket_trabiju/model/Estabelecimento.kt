package com.example.guiapocket_trabiju.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "estabelecimentos")
data class Estabelecimento(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val foto: Int = 0,  // Resource ID (para imagens do drawable)
    val fotoUri: String? = null,  // URI da imagem da galeria
    val nome: String,
    val categoria: String,
    val descricao: String,
    val telefone: String
) : Serializable