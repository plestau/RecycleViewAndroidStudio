package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityEjercicio3Binding

class Ejercicio3 : AppCompatActivity(), OnClickListener2 {
    private lateinit var binding : ActivityEjercicio3Binding
    private lateinit var pokemonadapter: PokemonAdapter
    private lateinit var capturadosadapter: PokemonAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        pokemonadapter = PokemonAdapter(mutableListOf(), this, false)
        capturadosadapter = PokemonAdapter(mutableListOf(), this, true)


        binding.recyclerViewLista.apply {
            layoutManager = LinearLayoutManager(this@Ejercicio3)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            adapter = pokemonadapter
        }

        binding.recyclerViewCapturados.apply {
            layoutManager = LinearLayoutManager(this@Ejercicio3)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            adapter = capturadosadapter
        }


        binding.btnAnadir.setOnClickListener {
            val pokemonName = binding.etNombrePokemon.text.toString()
            if (pokemonName.isNotEmpty()) {
                var pokemon = Pokemon(pokemonName, 100, "Normal", 1)
                addPokemonAuto(pokemon)
                binding.etNombrePokemon.text?.clear()
            } else {
                binding.etNombrePokemon.error = "El nombre no puede estar vacío"
            }
        }
    }

    private fun getData(){
        val data = mutableListOf(
            Pokemon("Pikachu", 100, "Electrico", 1),
            Pokemon("Mewtwo", 100, "Psiquico", 1),
            Pokemon("Snorlax", 100, "Normal", 1),
            Pokemon("Gyarados", 100, "Agua", 1),
            Pokemon("Dragonite", 100, "Dragon", 1),
            Pokemon("Salamence", 100, "Dragon", 1),
        )

        data.forEach{pokemon ->
            addPokemonAuto(pokemon)
        }
    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    private fun addPokemonAuto(pokemon: Pokemon) {
        if(pokemon.capturado) {
            capturadosadapter.addPokemon(pokemon)
        } else {
            pokemonadapter.addPokemon(pokemon)
        }
    }

    private fun removePokemonAuto(pokemon: Pokemon) {
        val builder = android.app.AlertDialog.Builder(this)
        builder.setMessage("¿Estás seguro que quieres eliminar el Pokémon ${pokemon.nombre}?")
        builder.setPositiveButton("Sí") { _, _ ->
            pokemonadapter.removePokemon(pokemon)
        }
        builder.setNegativeButton("No") { _, _ ->

        }
        builder.show()
    }

    override fun onLongClick(pokemon: Pokemon) {
        removePokemonAuto(pokemon)
    }

    override fun onPokemonCaptured(pokemon: Pokemon) {
        pokemon.capturado = true
        pokemonadapter.removePokemon(pokemon)
        capturadosadapter.addPokemon(pokemon)
    }

    override fun onPokemonReleased(pokemon: Pokemon) {
        pokemon.capturado = false
        capturadosadapter.removePokemon(pokemon)
        pokemonadapter.addPokemon(pokemon)
    }
}