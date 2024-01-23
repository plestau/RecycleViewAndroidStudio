package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ejercicio2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager

        val chessPieces = listOf(
            R.drawable.bishop to "Alfil",
            R.drawable.chess_king to "Rey",
            R.drawable.knight to "Caballo",
            R.drawable.pawn to "Peón",
            R.drawable.queen_chess_piece_black_shape to "Reina",
            R.drawable.rook to "Torre"
        )

        val chessAdapter = ChessAdapter(this, chessPieces)
        recyclerView.adapter = chessAdapter
    }
}

