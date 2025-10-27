package com.example.guiapocket_trabiju.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.guiapocket_trabiju.databinding.ItemEstabelecimentoBinding
import com.example.guiapocket_trabiju.model.Estabelecimento

class EstabelecimentoAdapter (
    private val context: Context,
    private val lista: List<Estabelecimento>
) : ArrayAdapter<Estabelecimento>(context, 0, lista) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemEstabelecimentoBinding

        if (convertView == null){
            binding = ItemEstabelecimentoBinding.inflate(LayoutInflater.from(context), parent, false)
            val itemView = binding.root
            itemView.tag = binding
        } else {
            binding = convertView.tag as ItemEstabelecimentoBinding
        }

        val estabelecimento = lista[position]
        binding.nomeEstabelecimento.text = estabelecimento.nome
        binding.categoriaEstabelecimento.text = estabelecimento.categoria
        binding.foto.setImageResource(estabelecimento.foto)

        return binding.root;
    }
}