package com.example.guiapocket_trabiju.data

import android.content.Context
import com.example.guiapocket_trabiju.model.Estabelecimento
import java.util.concurrent.Executors

class EstabelecimentoRepository(context: Context) {

    private val dao: EstabelecimentoDao
    private val executor = Executors.newSingleThreadExecutor()

    init {
        val database = AppDatabase.getDatabase(context)
        dao = database.estabelecimentoDao()
    }

    fun inserir(estabelecimento: Estabelecimento, callback: (Long) -> Unit) {
        executor.execute {
            val id = dao.inserir(estabelecimento)
            callback(id)
        }
    }

    fun atualizar(estabelecimento: Estabelecimento, callback: () -> Unit) {
        executor.execute {
            dao.atualizar(estabelecimento)
            callback()
        }
    }

    fun deletar(estabelecimento: Estabelecimento, callback: () -> Unit) {
        executor.execute {
            dao.deletar(estabelecimento)
            callback()
        }
    }

    fun listarTodos(callback: (List<Estabelecimento>) -> Unit) {
        executor.execute {
            val lista = dao.listarTodos()
            callback(lista)
        }
    }

    fun buscarPorNome(termo: String, callback: (List<Estabelecimento>) -> Unit) {
        executor.execute {
            val lista = dao.buscarPorNome(termo)
            callback(lista)
        }
    }

    fun buscarPorId(id: Int, callback: (Estabelecimento?) -> Unit) {
        executor.execute {
            val estabelecimento = dao.buscarPorId(id)
            callback(estabelecimento)
        }
    }
}