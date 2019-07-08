package com.example.clinica

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import java.text.SimpleDateFormat

class AdaptadorPaciente (

    private val listaPacientes: List<Paciente>,
    private val contexto: PacienteActivity,
    private val recyclerView: RecyclerView

):RecyclerView.Adapter<AdaptadorPaciente.MyViewHolder>(){

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombreTxt: TextView
        val apellidoTxt: TextView
        val fechaNacTxt: TextView
        val alergiasTxt: TextView
        val updateBtn: ImageButton
        val deleteBtn: ImageButton
        var idBase:Int? = -1
        var posicion = -1

        init {
            nombreTxt = view.findViewById(R.id.paciente_rvitem_desc_nom) as TextView
            apellidoTxt = view.findViewById(R.id.paciente_rvitem_desc_ape) as TextView
            fechaNacTxt = view.findViewById(R.id.paciente_rvitem_desc_fechNac) as TextView
            alergiasTxt = view.findViewById(R.id.paciente_rvitem_desc_aler) as TextView
            updateBtn = view.findViewById(R.id.paciente_rvitem_btn_update) as ImageButton
            deleteBtn = view.findViewById(R.id.paciente_rvitem_btn_delete) as ImageButton


            deleteBtn.setOnClickListener{

                if (idBase != -1 ) {
                    var str:String = "http://192.168.1.102:3000/clinica/pacientes/eliminar/" +idBase
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
        return listaPacientes.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorPaciente.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.paciente_element,
                p0,
                false
            )

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(p0: AdaptadorPaciente.MyViewHolder, p1: Int) {

        val paciente=listaPacientes[p1]

        p0.nombreTxt.text = paciente.nombre
        p0.apellidoTxt.text = paciente.apellido
        //val format = SimpleDateFormat("dd/MM/yyyy")
        p0.fechaNacTxt.text = paciente.fechaNac
        p0.alergiasTxt.text = paciente.alergias
        p0.idBase = paciente.id
        p0.posicion = p1
    }
}