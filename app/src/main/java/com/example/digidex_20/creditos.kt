package com.example.digidex_20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class creditos : Fragment() {
    lateinit var boton1: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_creditos, container, false)
        boton1 = vista.findViewById(R.id.btn_ir_pricipal)
        boton1.setOnClickListener {
            findNavController().navigate(R.id.action_creditos_to_principal)
        }
        return vista
    }

}