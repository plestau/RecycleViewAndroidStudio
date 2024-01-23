package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemPokemonBinding

class PokemonAdapter(var datos: MutableList<Pokemon>, private val listener: OnClickListener2, private val isCapturadosList: Boolean): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemPokemonBinding.bind(view)

        fun setListener(pokemon: Pokemon) {
            binding.root.setOnLongClickListener {
                listener.onLongClick(pokemon)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = datos.get(position)
        holder.setListener(pokemon)
        holder.binding.textView.text = pokemon.nombre
        holder.binding.checkBox.isChecked = pokemon.capturado
        holder.binding.checkBox.setOnClickListener {
            if (holder.binding.checkBox.isChecked) {
                listener.onPokemonCaptured(pokemon)
            } else {
                listener.onPokemonReleased(pokemon)
            }
        }
    }

    fun addPokemon(pokemon: Pokemon) {
        datos.add(pokemon)
        notifyDataSetChanged()
    }

    fun removePokemon(pokemon: Pokemon) {
        datos.remove(pokemon)
        notifyDataSetChanged()
    }
}