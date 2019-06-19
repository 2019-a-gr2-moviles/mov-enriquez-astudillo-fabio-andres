package com.example.myapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.recycler_view.*

class NewAdapter
(
    private val listaNews: List<New>,
    private val contexto: MainActivity,
    private val recyclerView: RecyclerView
) :
    RecyclerView.Adapter<NewAdapter.MyViewHolder>()
{

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var nombreTxv: TextView
        var cedulaTxv: TextView

        init {
            nombreTxv = view.findViewById(R.id.txv_name) as TextView
            cedulaTxv = view.findViewById(R.id.txv_ci) as TextView

            val layout = view.findViewById(R.id.ly_element) as LinearLayout


        }


    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NewAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.rv_element, p0,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaNews.size
    }

    override fun onBindViewHolder
    (
        myViewHolder: NewAdapter.MyViewHolder,
        position: Int
    )
    {
        val persona = listaNews[position]

        myViewHolder.nombreTxv.text = persona.nombre
        myViewHolder.cedulaTxv.text = persona.cedula
    }


}