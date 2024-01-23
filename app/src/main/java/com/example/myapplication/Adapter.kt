package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemPersonaBinding

class Adapter(private val listaPersona: List<Persona>, private val clickListener: OnClickListener) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemPersonaBinding.bind(view)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_persona, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaPersona.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val persona = listaPersona.get(position)
        holder.binding.nombre.text = persona.nombre
        holder.binding.correo.text = persona.correo
        holder.binding.telefono.text = persona.telefono
    }
}