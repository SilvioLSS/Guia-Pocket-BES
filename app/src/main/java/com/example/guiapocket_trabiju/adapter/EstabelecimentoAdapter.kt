package com.example.guiapocket_trabiju.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.guiapocket_trabiju.databinding.ItemEstabelecimentoBinding
import com.example.guiapocket_trabiju.model.Estabelecimento

class EstabelecimentoAdapter(
    private var estabelecimentos: List<Estabelecimento>,
    private val onClick: (Estabelecimento) -> Unit
) : RecyclerView.Adapter<EstabelecimentoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemEstabelecimentoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(estabelecimentos[position])
    }

    override fun getItemCount(): Int = estabelecimentos.size

    fun updateLista(novaLista: List<Estabelecimento>) {
        estabelecimentos = novaLista
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemEstabelecimentoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(estabelecimento: Estabelecimento) {
            binding.nomeEstabelecimento.text = estabelecimento.nome
            binding.categoriaEstabelecimento.text = estabelecimento.categoria
            binding.foto.setImageResource(estabelecimento.foto)

            binding.root.setOnClickListener {
                onClick(estabelecimento)
            }
        }
    }
}
