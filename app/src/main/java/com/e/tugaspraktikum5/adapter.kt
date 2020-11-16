package com.e.tugaspraktikum5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_makanan.view.*

class adapter(val resepItemList: List<makanan>, val clickListener: (makanan) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_makanan, parent, false)
        return PartViewHolder(view)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(resepItemList[position], clickListener)
    }
    override fun getItemCount() = resepItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(fak: makanan, clickListener: (makanan) -> Unit) {
            itemView.namajajan.text = fak.NamaJajan.toString()
            itemView.imgjajan.setImageResource(fak.imgJajan)

            itemView.setOnClickListener{clickListener(fak)}
        }
    }
}