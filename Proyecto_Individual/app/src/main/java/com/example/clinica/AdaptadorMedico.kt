package com.example.clinica

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.result.Result

class AdaptadorMedico (

    private val listaMedicos: List<Medico>,
    private val contexto: MedicoActivity,
    private val recyclerView: RecyclerView

): RecyclerView.Adapter<AdaptadorMedico.MyViewHolder>(){

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombreTxt: TextView
        val oficinaTxt: TextView
        val especialidadTxt: TextView
        val updateBtn: ImageButton
        val deleteBtn: ImageButton
        var idBase:Int? = -1
        var posicion = -1

        init {
            nombreTxt = view.findViewById(R.id.medico_rvitem_desc_nom) as TextView
            oficinaTxt = view.findViewById(R.id.medico_rvitem_desc_ofi) as TextView
            especialidadTxt = view.findViewById(R.id.medico_rvitem_desc_esp) as TextView
            updateBtn = view.findViewById(R.id.medico_rvitem_btn_update) as ImageButton
            deleteBtn = view.findViewById(R.id.medico_rvitem_btn_delete) as ImageButton


            deleteBtn.setOnClickListener{

                if (idBase != -1 ) {
                    var str:String = "http://172.29.27.165:3000/clinica/medicos/eliminar/" +idBase
                    str
                        .httpDelete()
                        .responseString { request, response, result ->
                            when (result) {
                                is Result.Failure -> {
                                    val ex = result.getException()
                                    Log.i("http","No se elimino :(")
                                }
                                is Result.Success -> {
                                    val data:String = result.get()
                                    Log.i("http","Eliminadof :P")
                                }
                            }
                        }
                }

            }

        }
    }
    override fun getItemCount(): Int {
        return listaMedicos.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorMedico.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.medico_element,
                p0,
                false
            )

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(p0: AdaptadorMedico.MyViewHolder, p1: Int) {

        val medico=listaMedicos[p1]

        p0.nombreTxt.text = medico.nombre
        //val format = SimpleDateFormat("dd/MM/yyyy")
        p0.oficinaTxt.text = medico.oficina
        p0.especialidadTxt.text = medico.especialidad
        p0.idBase = medico.id
        p0.posicion = p1
    }

}