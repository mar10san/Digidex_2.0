package com.example.digidex_20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class principal : Fragment() {
    lateinit var boton1:Button
    lateinit var boton2:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_principal, container, false)
        boton1 = vista.findViewById(R.id.btn_ir_mensaje)
        boton1.setOnClickListener {
            findNavController().navigate(R.id.action_principal_to_mensaje)
        }
        boton2 = vista.findViewById(R.id.btn_ir_creditos)
        boton2.setOnClickListener {
            findNavController().navigate(R.id.action_principal_to_creditos)
        }
        return vista
    }

}