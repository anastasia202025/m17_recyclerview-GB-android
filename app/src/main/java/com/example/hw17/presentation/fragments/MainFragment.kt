package com.example.hw17.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.hw17.data.model.Mars
import com.example.hw17.presentation.MarsAdaptor
import com.example.hw17.presentation.viewmodel.MainViewModel
import com.example.hw17.presentation.viewmodel.ViewModelFactory
import com.hw17.R
import com.hw17.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: MainViewModel by viewModels { viewModelFactory }
    private lateinit var adapterMars: MarsAdaptor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapterMars = MarsAdaptor { photoMoon -> onClickMars(photoMoon) }
        downloadList()
        setupRecyclerView()
        observeData()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapterMars
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.photosMars.collect { photosModel ->
                val photos = photosModel.photos
                adapterMars.submitList(photos)
            }
        }
    }

    private fun downloadList() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loadData()
        }
    }

    private fun onClickMars(item: Mars) {
        val fragment = DetailedFragment.newInstance(item)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view_tag, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}