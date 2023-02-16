package com.adhitya.beratbadanrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (private val dataset: MutableList<Data>):
    RecyclerView.Adapter<Adapter.DataHolder>() {
    class DataHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nama = view.findViewById<TextView>(R.id.Nama)
        val tinggi = view.findViewById<TextView>(R.id.Tinggi)
        val berat = view.findViewById<TextView>(R.id.Berat)
        val btnHapus = view.findViewById<ImageView>(R.id.Delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_adapter, parent, false
        )
        return DataHolder(view)
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val data = dataset[position]
        holder.nama.text = data.nama
        holder.tinggi.text = data.tinggi
        holder.berat.text = data.berat.toString()
        holder.btnHapus.setOnClickListener {
            dataset.removeAt(position)
            notifyItemRangeRemoved(position, dataset.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}