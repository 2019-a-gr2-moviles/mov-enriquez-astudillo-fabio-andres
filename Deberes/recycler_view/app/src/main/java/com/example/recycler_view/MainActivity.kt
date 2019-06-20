package com.example.recycler_view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.myapplication.NewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.supportActionBar?.hide()

        val list = ArrayList<New>();
        list.add(New("La UE prorroga un año sanciones contra Rusia adoptadas tras anexión de Crimea","Hace 34 min"))
        list.add(New("Vivien Maier, la niñera que pasó a la historia de la fotografía","Ayer"))
        list.add(New("Un vehículo en llamas causó un incendio forestal en la av. Simón Bolívar, en Quito","Hace 2 horas"))
        list.add(New("Hernán Darío Gómez y Reinaldo Rueda: un duelo de carreras paralelas","Hace 2 horas"))
        list.add(New("Un corredor urbanístico de 43,8 km se planifica en Quito","5 min"))
        list.add(New("Fiscal imputa más delitos a Alexis Mera y a María de los Ángeles Duarte","Hace tres días"))
        list.add(New("La atención en Guagua Centros de Quito está bajo revisión","Ayer"))
        list.add(New("Énner Valencia es la mejor carta de gol de la Tri en la Copa América","Hace 45 min"))
        list.add(New("La producción de crudo subió hasta abril de este 2019 en Ecuador","Hace 2 días"))

        iniciarRecylerView(list, this, rv_main)

    }

    fun iniciarRecylerView(
        lista: ArrayList<New>,
        actividad: MainActivity,
        recycler_view: RecyclerView
    ) {
        val adaptadorPersona = NewAdapter(
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
