package com.example.guiapocket_trabiju.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.guiapocket_trabiju.model.Estabelecimento

@Dao
interface EstabelecimentoDao {

    @Insert
    fun inserir(estabelecimento: Estabelecimento): Long

    @Update
    fun atualizar(estabelecimento: Estabelecimento)

    @Delete
    fun deletar(estabelecimento: Estabelecimento)

    @Query("SELECT * FROM estabelecimentos ORDER BY nome ASC")
    fun listarTodos(): List<Estabelecimento>

    @Query("SELECT * FROM estabelecimentos WHERE id = :id")
    fun buscarPorId(id: Int): Estabelecimento?

    @Query("SELECT * FROM estabelecimentos WHERE nome LIKE '%' || :termo || '%' ORDER BY nome ASC")
    fun buscarPorNome(termo: String): List<Estabelecimento>

    @Query("DELETE FROM estabelecimentos")
    fun deletarTodos()
}