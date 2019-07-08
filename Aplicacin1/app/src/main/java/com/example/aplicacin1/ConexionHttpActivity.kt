package com.example.aplicacin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.beust.klaxon.Klaxon
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList
import com.github.kittinunf.result.Result.*
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost

class ConexionHttpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conexion_http)

        val json = """
            [
                {
                  "usuariosDeEmpresa": [
                      {
                          "createdAt": 1561663617636,
                          "updatedAt": 1561663617636,
                          "id": 1,
                          "nombre": "Adrian",
                          "fkEmpresa": 1,
                      },
                      {
                          "createdAt": 1561663617636,
                          "updatedAt": 1561663617636,
                          "id": 2,
                          "nombre": "Fabio",
                          "fkEmpresa": 1,
                      }
                  ],
                  "createdAt": 1561663617636,
                  "updatedAt": 1561663617636,
                  "id": 1,
                  "nombre": "Manticore Labs"
                }
            ]
        """.trimIndent()

        try {
            val empresaInstancia = Klaxon()
                .parseArray<Empresa>(json)

            empresaInstancia?.forEach {

                Log.i(
                    "http",
                    "Nombre ${it.nombre}"
                )

                Log.i(
                    "http",
                    "Id ${it.id}"
                )

                Log.i(
                    "http",
                    "Fecha ${it.fechaCreacion}"
                )

                it.usuariosDeEmpresa.forEach {
                    Log.i(
                        "http",
                        "Nombre ${it.nombre}"
                    )
                    Log.i(
                        "http",
                        "FK ${it.fkEmpresa}"
                    )
                }

            }
        } catch (e: Exception) {
            Log.i("http", "${e.message}")
            Log.i(
                "http",
                "Error instanciando la empresa"
            )
        }

        "http://172.29.146.126:1337/empresa/1"
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Success -> {
                        val data = result.get()
                        Log.i("http", "Data: ${data}")

                        val empresaParseada = Klaxon()
                            .parse<Empresa>(data)
                        if (empresaParseada != null) {
                            Log.i("http", " iiiiiiiiiiiiiiiiiiii ")
                            Log.i("http", "${empresaParseada.nombre} ")
                            Log.i("http", "${empresaParseada.id} ")
                        }
                    }
                }
            }

        val parametrosCrearEmpresa = listOf(
            "nombre" to "PoliLabs"
        )
        val urlCrearEmpresa = "http://172.29.146.126:1337/empresa"
            .httpPost(parametrosCrearEmpresa)
            .responseString { request, response, result ->
                when(result){
                    is Failure -> {
                        val error = result.getException()
                        Log.i("http", "Error: ${error}")
                    }
                    is Success -> {
                        val empresaString = result.get()
                        Log.i("http", "$empresaString")
                    }
                }
            }
    }
}
