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
        list.add(New("FB","12"))
        list.add(New("DN","34"))
        list.add(New("DN","34"))
        list.add(New("DN","34"))
        list.add(New("DN","34"))
        list.add(New("DN","34"))
        list.add(New("DN","34"))
        list.add(New("DN","34"))
        list.add(New("DN","34"))

        iniciarRecylerView(list, this, rv_main)

    }

    fun iniciarRecylerView(
        lista: List<New>,
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
