package com.example.myapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.recycler_view.*

class AdaptadorPersona
(
    private val listaPersonas: List<Persona>,
    private val contexto: MainActivity,
    private val recyclerView: RecyclerView
) :
    RecyclerView.Adapter<AdaptadorPersona.MyViewHolder>()
{

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var nombreTxv: TextView
        var cedulaTxv: TextView
        var startBtn: Button

        init {
            nombreTxv = view.findViewById(R.id.txv_name) as TextView
            cedulaTxv = view.findViewById(R.id.txv_ci) as TextView
            startBtn = view.findViewById(R.id.btn_ready) as Button

            val layout = view.findViewById(R.id.ly_element) as LinearLayout

            startBtn.setOnClickListener {
                nombreTxv.text = "ME CAMBIAROON!!! "
            }
        }


    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorPersona.MyViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.rv_element, p0,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaPersonas.size
    }

    override fun onBindViewHolder
    (
        myViewHolder: AdaptadorPersona.MyViewHolder,
        position: Int
    )
    {
        val persona = listaPersonas[position]

        myViewHolder.nombreTxv.text = persona.nombre
        myViewHolder.cedulaTxv.text = persona.cedula
    }


}