package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChessAdapter(private val context: Context, private val chessPieces: List<Pair<Int, String>>) :
    RecyclerView.Adapter<ChessAdapter.ChessViewHolder>() {

    class ChessViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageChessPiece)
        val textChessPieceName: TextView = itemView.findViewById(R.id.textChessPieceName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChessViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_chess_piece, parent, false)
        return ChessViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChessViewHolder, position: Int) {
        val (chessPieceDrawable, chessPieceName) = chessPieces[position]
        holder.imageView.setImageResource(chessPieceDrawable)
        holder.textChessPieceName.text = chessPieceName
    }

    override fun getItemCount(): Int {
        return chessPieces.size
    }
}
