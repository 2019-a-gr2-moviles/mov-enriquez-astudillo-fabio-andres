package com.example.aplicacin1

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_rsultado_propio.*

class RsultadoPropioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rsultado_propio)

        btn_res_propio.setOnClickListener{
            devolverRespuesta()
        }
    }

    fun devolverRespuesta(){
        val nombre = "Adrian"
        val edad = 30

        val intentRespuesta = Intent()

        intentRespuesta.putExtra("nombre de usuario", nombre)
        intentRespuesta.putExtra("edad de usuario", edad)

        this.setResult(
            RESULT_OK, //Podemos enviar RESULT_OK o RESULT_CANCELED
            intentRespuesta
        )

        this.finish()
    }
}
