package com.example.aplicacin1

import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class AdaptadorPersona(
    private val listaPersonas: List<Persona>,
    private val contexto: ReciclerViewActivity,
    private val recyclerView: androidx.recyclerview.widget.RecyclerView
):
    androidx.recyclerview.widget.RecyclerView.Adapter<AdaptadorPersona.MyViewHolder>()
{

    inner class MyViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {

        var nombreTextView: TextView
        var cedulaTextView: TextView
        var accionBoton: Button

        init {
            nombreTextView = view.findViewById(R.id.txt_nombre) as TextView
            cedulaTextView = view.findViewById(R.id.txt_ci) as TextView
            accionBoton = view.findViewById(R.id.btn_accion) as Button

            val layout = view.findViewById(R.id.linear_layout) as LinearLayout

            layout.setOnClickListener {
                Log.i("recycler-view","Layout Presionado")

            }
            accionBoton.setOnClickListener{
                nombreTextView.text = "ME CAMBIAROOOON"
                contexto.cambiarNombreTextView("Wow!!!")

                val nuevasPersonas = arrayListOf<Persona>()

                nuevasPersonas.add(Persona("David","000005"))
                nuevasPersonas.add(Persona("Alejandro","000006"))
                nuevasPersonas.add(Persona("Pablo","000007"))
                nuevasPersonas.add(Persona("Gabriel","000008"))

                contexto.iniciarRecylerView(nuevasPersonas, contexto, recyclerView)
            }
        }
    }

    //devuelve el número de items de la lista
    override fun getItemCount(): Int {
        return listaPersonas.size
    }


    override fun onBindViewHolder(
        myViewHolder: AdaptadorPersona.MyViewHolder,
        position: Int
    ) {
        val persona = listaPersonas[position]
        myViewHolder.nombreTextView.text = persona.nombre
        myViewHolder.cedulaTextView.text = persona.cedula
    }


    //esta funcion define el template que vamos a utilizar, el template está en la carpeta de res/layout
    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): AdaptadorPersona.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout,
                p0,
                false
            )
        return MyViewHolder(itemView)
    }


}