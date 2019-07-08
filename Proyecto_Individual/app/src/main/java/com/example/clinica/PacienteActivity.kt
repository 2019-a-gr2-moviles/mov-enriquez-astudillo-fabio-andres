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
import kotlinx.android.synthetic.main.activity_paciente.*
import com.github.kittinunf.result.Result.*
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

class PacienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paciente)
        pac_floatbtn.setOnClickListener{
            irACrearPaciente()
        }
        pac_floatbtn_refresh.setOnClickListener{
            refrescar()
        }

        cargarBottomBar()
        iniciarRecylerView(Paciente.ArrarPacientes,this,pacList_rv)
        cargarRegistros()



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        return super.onCreateOptionsMenu(menu)
    }

    fun cargarBottomBar(){
        pac_bnv.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_paciente -> {
                    true
                }
                R.id.action_cita -> {
                    irACitaActivity()
                    true
                }
                R.id.action_medico -> {
                    irAMedicoActivity()
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

    fun irAMedicoActivity(){
        val intentExplicito = Intent(
            this,MedicoActivity::class.java
        )
        startActivity(intentExplicito)
    }

    fun irACrearPaciente(){
        val intentExplicito = Intent(
            this,CrearPacienteActivity::class.java
        )
        startActivity(intentExplicito)
    }


    fun iniciarRecylerView(
        lista: List<Paciente>?,
        actividad: PacienteActivity,
        recycler_view: RecyclerView
    ) {
        if (lista != null){
            val adaptadorPaciente = AdaptadorPaciente(
                lista,
                actividad,
                recycler_view
            )
            recycler_view.adapter = adaptadorPaciente
            recycler_view.itemAnimator = DefaultItemAnimator()
            recycler_view.layoutManager = LinearLayoutManager(actividad)

            adaptadorPaciente.notifyDataSetChanged()
        }
    }

    fun cargarRegistros(){

        "http://192.168.1.102:3000/clinica/pacientes/listar"
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http","No se inicio :(")
                    }
                    is Result.Success -> {
                        val data:String = result.get()
                        Paciente.ArrarPacientes = Klaxon().parseArray(data)
                        Log.i("http","OK :P")
                    }
                }
            }

    }

    fun refrescar(){
        cargarRegistros()
        iniciarRecylerView(Paciente.ArrarPacientes,this,pacList_rv)
    }

}
