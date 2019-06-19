package com.example.recycler_view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.myapplication.AdaptadorPersona
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.supportActionBar?.hide()

        val list = ArrayList<Persona>();
        list.add(Persona("FB","12"))
        list.add(Persona("DN","34"))
        list.add(Persona("DN","34"))
        list.add(Persona("DN","34"))
        list.add(Persona("DN","34"))
        list.add(Persona("DN","34"))
        list.add(Persona("DN","34"))
        list.add(Persona("DN","34"))
        list.add(Persona("DN","34"))

        iniciarRecylerView(list, this, rv_main)

    }

    fun iniciarRecylerView(
        lista: List<Persona>,
        actividad: MainActivity,
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
}
