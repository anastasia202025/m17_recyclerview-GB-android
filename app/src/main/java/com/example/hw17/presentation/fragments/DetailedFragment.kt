package com.example.hw17.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.hw17.data.model.Mars
import com.hw17.R
import com.hw17.databinding.FragmentDetailedBinding

class DetailedFragment : Fragment() {
    private var _binding: FragmentDetailedBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance(item: Mars): DetailedFragment {
            val fragment = DetailedFragment()
            val args = Bundle()
            args.putParcelable("mars_item", item)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailedBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<Mars>("mars_item")?.let { item ->
            showDetails(item)
        }
        activity?.actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun showDetails(item: Mars) {
        binding.rover.text = "Rover: ${item.rover.name}"
        binding.camera.text = "Camera: ${item.camera.name}"
        binding.sol.text = "Sol: ${item.sol}"
        binding.date.text = "Date: ${item.earthDate}"

        val newImgSrc = item.imgSrc
            .replace("http://mars.jpl.nasa.gov", "https://mars.nasa.gov")

        Glide.with(binding.root.context)
            .load(newImgSrc)
            .centerCrop()
            .error(R.mipmap.ic_launcher_round)
            .into(binding.imgMars)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            requireActivity().onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        requireActivity().actionBar?.setDisplayHomeAsUpEnabled(false)
    }
}