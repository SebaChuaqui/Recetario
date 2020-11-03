package com.example.recetario.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.recetario.R
import com.example.recetario.ViewModel.RecetaViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    lateinit var mRecetasViewModel: RecetaViewModel

    var recetasId = 0
    var recetasImg = ""
    var recetasname = ""
    var recetasingredientes = ""
    var recetaspreparacion = ""
    var recetasrecomendacion = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mRecetasViewModel = ViewModelProvider(this).get(RecetaViewModel::class.java)
        arguments?.let {
            recetasId = it.getInt("id")
            recetasImg = it.getString("img").toString()
            recetasname = it.getString("name").toString()
            recetasingredientes = it.getString("ing").toString()
            recetaspreparacion = it.getString("prepa").toString()
            recetasrecomendacion = it.getString("rec").toString()

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        namereceta.text = recetasname
        nameingredientes.text = recetasingredientes
        namepreparacion.text = recetaspreparacion
        namerecomendacion.text = recetasrecomendacion
        Glide.with(this)
            .load(recetasImg)
            .into(imageView)

        // view.findViewById<Button>(R.id.button_second).setOnClickListener {
        // findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        // }

        fab.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener(){


            val intent = Intent(Intent.ACTION_SEND)
            val to = "info@plaplix.cl"
            val addressees = arrayOf(to)
            val subject = "Asunto "
            val message = "Hola \nVi este super Heroe llamado  y quiero comprarlo llámame al _________"
            intent.putExtra(Intent.EXTRA_EMAIL, addressees)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Contactar Area de Ventas:"))
        }
    }
}
