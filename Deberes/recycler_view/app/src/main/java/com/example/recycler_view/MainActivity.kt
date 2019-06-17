package com.example.recycler_view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.example.myapplication.AdaptadorPersona
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<Persona>();

        list.add(Persona("FB","12"))
        list.add(Persona("DN","34"))

        val adaptador = AdaptadorPersona(list, this, rv_main)

        rv_main.adapter = adaptador
        rv_main.itemAnimator = DefaultItemAnimator()
        rv_main.layoutManager = LinearLayoutManager(this)

    }
}
