package com.example.aplicacin1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recicler_view.*

class ReciclerViewActivity : AppCompatActivity() {

    fun iniciarRecylerView(
        lista: List<Persona>,
        actividad: ReciclerViewActivity,
        recycler_view: RecyclerView
    ) {
        val adaptadorPersona = AdaptadorPersona(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorPersona
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)

        adaptadorPersona.notifyDataSetChanged()
    }

    fun cambiarNombreTextView(texto: String) {
        txv_titulo_rv.text = texto
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler_view)

        val lista = arrayListOf<Persona>()

        lista.add(Persona("Fabio", "000001"))
        lista.add(Persona("Daniel", "000002"))
        lista.add(Persona("Pablo", "000003"))
        lista.add(Persona("Paul", "000004"))

        iniciarRecylerView(lista, this, rv_personas)
    }
}


//        val adaptadorPersona = AdaptadorPersona(lista, this, rv_personas)
//
//        rv_personas.adapter = adaptadorPersona
//        rv_personas.itemAnimator = DefaultItemAnimator()
//        rv_personas.layoutManager = LinearLayoutManager(this)
//
//        adaptadorPersona.notifyDataSetChanged()




