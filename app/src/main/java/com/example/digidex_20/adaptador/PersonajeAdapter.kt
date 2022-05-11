package com.example.digidex_20.adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.digidex_20.R
import com.example.digidex_20.modelo.Personaje
import com.squareup.picasso.Picasso

class PersonajeAdapter(private val listaPersonajes:ArrayList<Personaje>): RecyclerView.Adapter<PersonajeAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.vista_propia,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNombre.text=listaPersonajes[position].nombre
        Picasso.get()
            .load(listaPersonajes[position].foto)
            .into(holder.ivFoto)
        holder.tvNivel.text=listaPersonajes[position].nivel
    }

    override fun getItemCount(): Int {
        return listaPersonajes.size
    }

    class ViewHolder(vista:View):RecyclerView.ViewHolder(vista){
        val tvNombre:TextView = vista.findViewById(R.id.tvNombreP)
        val ivFoto:ImageView = vista.findViewById(R.id.imaPersonaje)
        val tvNivel:TextView = vista.findViewById(R.id.tvLevel)

    }
}