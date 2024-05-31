package com.example.hw17.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw17.data.model.Mars
import com.hw17.databinding.PhotoCardOfMarsBinding

class MarsAdaptor(private val onClick: (Mars) -> Unit) :
    RecyclerView.Adapter<MarsViewHolder>() {

    private var listMars: List<Mars> = emptyList()

    fun submitList(photos: List<Mars>) {
        listMars = photos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {
        val binding = PhotoCardOfMarsBinding
            .inflate(LayoutInflater.from(parent.context))
        return MarsViewHolder(binding, onClick)
    }

    override fun getItemCount(): Int {
        return listMars.size
    }

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        val item = listMars[position]
        holder.bind(item)
    }
}