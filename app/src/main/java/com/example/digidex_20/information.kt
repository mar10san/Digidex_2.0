@file:Suppress("ClassName")

package com.example.digidex_20

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.digidex_20.adaptador.PersonajeAdapter
import com.example.digidex_20.modelo.Personaje
import android.annotation.SuppressLint as SuppressLint1


class information : Fragment() {
    private lateinit var miRecycler:RecyclerView
    private lateinit var listaPersonajes:ArrayList<Personaje>
    private lateinit var adaptador:PersonajeAdapter
    private lateinit var mediaPlayer:MediaPlayer
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_informacion, container, false)
        reproduceMusica()
        listaPersonajes = ArrayList()
        miRecycler = vista.findViewById(R.id.RecyclerPersonajes)
        adaptador = PersonajeAdapter(listaPersonajes)
        miRecycler.adapter = adaptador
        getPersonajes()
        miRecycler.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        return vista
    }
    @SuppressLint1("NotifyDataSetChanged")
    fun getPersonajes(){
        val queue = Volley.newRequestQueue(requireContext())
        val url = "https://digimon-api.vercel.app/api/digimon"
        val objectRequest = JsonArrayRequest(
            Request.Method.GET,url,null,
            { respuesta ->
                for (indice in 0 until respuesta.length()){
                    val personajeIndJson = respuesta.getJSONObject(indice)
                    val personaje = Personaje(  personajeIndJson.getString("name"),
                                                personajeIndJson.getString("img"),
                                                personajeIndJson.getString("level"))
                    listaPersonajes.add(personaje)
                }

                adaptador.notifyDataSetChanged()
            },
            {
                Log.e("PersonajesApi", "Error")
            })

        queue.add(objectRequest)

    }
    override fun onStop(){
        super.onStop()
        mediaPlayer.release()
    }

    private fun reproduceMusica(){
        mediaPlayer = MediaPlayer.create(requireContext(),R.raw.audio)
        mediaPlayer.isLooping = true
        mediaPlayer.setVolume(15.0f,15.0f)
        mediaPlayer.start()
    }
}