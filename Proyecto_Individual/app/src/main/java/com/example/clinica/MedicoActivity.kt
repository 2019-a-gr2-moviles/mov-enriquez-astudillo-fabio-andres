package com.example.clinica

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_medico.*
import kotlinx.android.synthetic.main.activity_paciente.*

class MedicoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medico)

        med_floatbtn.setOnClickListener{
            irACrearMedico()
        }
        med_floatbtn_refresh.setOnClickListener{
            refrescar()
        }

        cargarBottomBar()
        iniciarRecylerView(Medico.ArrarMedicos,this,medList_rv)
        cargarRegistros()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        return super.onCreateOptionsMenu(menu)
    }

    fun cargarBottomBar(){
        med_bnv.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_paciente -> {
                    irAPacienteActivity()
                    true
                }
                R.id.action_cita -> {
                    irACitaActivity()
                    true
                }
                R.id.action_medico -> {
                    true
                }
                else -> false
            }
        }
    }

    fun irACitaActivity(){
        val intentExplicito = Intent(
            this,CitaActivity::class.java
        )
        startActivity(intentExplicito)
    }

    fun irAPacienteActivity(){
        val intentExplicito = Intent(
            this,PacienteActivity::class.java
        )
        startActivity(intentExplicito)
    }

    fun irACrearMedico(){
        val intentExplicito = Intent(
            this,CrearMedicoActivity::class.java
        )
        startActivity(intentExplicito)
    }


    fun iniciarRecylerView(
        lista: List<Medico>?,
        actividad: MedicoActivity,
        recycler_view: RecyclerView
    ) {
        if (lista != null){
            val adaptadorMedico = AdaptadorMedico(
                lista,
                actividad,
                recycler_view
            )
            recycler_view.adapter = adaptadorMedico
            recycler_view.itemAnimator = DefaultItemAnimator()
            recycler_view.layoutManager = LinearLayoutManager(actividad)

            adaptadorMedico.notifyDataSetChanged()
        }
    }

    fun cargarRegistros(){

        "http://172.29.27.165:3000/clinica/medicos/listar"
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http","No se inicio :(")
                    }
                    is Result.Success -> {
                        val data:String = result.get()
                        Log.i("http",data)
                        Medico.ArrarMedicos = Klaxon().parseArray(data)
                        Log.i("http","OK :P")
                    }
                }
            }

    }

    fun refrescar(){
        cargarRegistros()
        iniciarRecylerView(Medico.ArrarMedicos,this,medList_rv)
    }
}
