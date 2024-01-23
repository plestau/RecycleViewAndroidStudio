package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityEjercicio1Binding

class Ejercicio1 : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityEjercicio1Binding
    private lateinit var personaAdapter: Adapter // Cambié el nombre a personaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = mutableListOf(
            Persona("Juan", "juan@hotmail.com", "1234567890"),
            Persona("Pedro", "pedro@gmail.com", "0987654321"),
            Persona("Maria", "maria@correo.es", "6789054321"),
            Persona("Jose", "jose@correo.com", "1234567890"),
            Persona("Ana", "ana@correo.es", "0987654321"),
        )

        personaAdapter = Adapter(data, this)

        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = personaAdapter
    }

    override fun onLongClick(persona: Persona) {
        Toast.makeText(this, "Long click: ${persona.nombre}", Toast.LENGTH_SHORT).show()
    }
}
