package com.example.hw17.presentation

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hw17.data.model.Mars
import com.hw17.R
import com.hw17.databinding.PhotoCardOfMarsBinding

class MarsViewHolder(
    private val binding: PhotoCardOfMarsBinding,
    private val onClick: (Mars) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Mars) {
        with(binding) {
            rover.text = "Rover: ${item.rover.name}"
            camera.text = "Camera: ${item.camera.name}"
            sol.text = "Sol: ${item.sol}"
            date.text = "Date: ${item.earthDate}"

            val newImgSrc = item.imgSrc
                .replace("http://mars.jpl.nasa.gov", "https://mars.nasa.gov")
            Glide
                .with(root)
                .load(newImgSrc)
                .centerCrop()
                .error(R.mipmap.ic_launcher_round)
                .into(imgMars)

            root.setOnClickListener {
                onClick(item)
            }
        }
    }
}