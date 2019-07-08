package com.example.aplicacin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        maps.setOnClickListener {
            irAMapas()
        }

        btn_intent.setOnClickListener{
            irAIntentView()
        }

        btn_http.setOnClickListener{
            irAHttp()
        }
    }

    fun irAMapas(){
        val intentPropio = Intent(
            this,
            MapsActivity::class.java
        )

        this.startActivityForResult(intentPropio, 305)
    }

    fun irAIntentView(){
        val intentExplicito = Intent(
            this,IntentRespuestaActivity::class.java
        )

        startActivity(intentExplicito)
    }

    fun irAHttp(){
        val intentExplicito = Intent(
            this,ConexionHttpActivity::class.java
        )

        startActivity(intentExplicito)
    }


}



