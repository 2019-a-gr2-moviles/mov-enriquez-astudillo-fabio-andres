package com.example.clinica

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_crear_paciente.*

class CrearPacienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_paciente)

        crePac_btn.setOnClickListener{
            crear()
        }
    }

    fun crear(){



        val parameters = listOf(
            "nombre" to crePac_txtin_nombre.text,
            "apellido" to crePac_txtin_apellido.text,
            "fechaNac" to crePac_txtin_fechNac.text,
            "alergias" to crePac_txtin_alergias.text
        )

        "http://172.29.27.165:3000/clinica/pacientes/crear"
            .httpPost(parameters)
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http","No se creo :(")
                    }
                    is Result.Success -> {
                        val data:String = result.get()
                        Log.i("http","CREADO :P")
                        irAPacienteActivity()
                    }
                }
            }

    }

    fun irAPacienteActivity(){
        val intentExplicito = Intent(
            this,PacienteActivity::class.java
        )
        startActivity(intentExplicito)
    }


}
