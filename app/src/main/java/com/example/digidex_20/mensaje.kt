@file:Suppress("ClassName")

package com.example.digidex_20

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView


class mensaje : Fragment() {
    private lateinit var boton1: Button
    private lateinit var boton2: Button
    private lateinit var animView: LottieAnimationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_mensaje, container, false)
        animView = vista.findViewById(R.id.animationView)
        animView.setAnimation(R.raw.internet)
        boton1 = vista.findViewById(R.id.btn_it_informacion)
        boton1.setOnClickListener {
            findNavController().navigate(R.id.action_mensaje_to_informacion)
        }
        boton2 = vista.findViewById(R.id.btn_ir_principal)
        boton2.setOnClickListener {
            findNavController().navigate(R.id.action_mensaje_to_principal)
        }
        return vista
    }
}