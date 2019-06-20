package com.example.myapplication

import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.recycler_view.*

class NewAdapter
(
    private val listaNews: ArrayList<New>,
    private val contexto: MainActivity,
    private val recyclerView: RecyclerView
) :
    RecyclerView.Adapter<NewAdapter.MyViewHolder>()
{

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var titleTxv: TextView
        var dateTxv: TextView
        var notInteresting: Button
        var imageView: ImageView

        init {
            titleTxv = view.findViewById(R.id.txv_title) as TextView
            dateTxv = view.findViewById(R.id.txv_date) as TextView
            notInteresting = view.findViewById(R.id.btn_ni) as Button
            imageView = view.findViewById(R.id.imageView) as ImageView

            val layout = view.findViewById(R.id.ly_element) as LinearLayout

            notInteresting.setOnClickListener{
                listaNews.removeAt(getAdapterPosition())
                contexto.iniciarRecylerView(listaNews,contexto,recyclerView)
            }
        }


    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NewAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.rv_element, p0,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaNews.size
    }

    override fun onBindViewHolder
    (
        myViewHolder: NewAdapter.MyViewHolder,
        position: Int
    )
    {
        val new = listaNews[position]

        myViewHolder.titleTxv.text = new.title
        myViewHolder.dateTxv.text = new.date
        myViewHolder.imageView.setImageResource(new.img)

    }


}