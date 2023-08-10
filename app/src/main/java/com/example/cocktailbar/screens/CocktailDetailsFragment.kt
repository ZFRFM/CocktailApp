package com.example.cocktailbar.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.cocktailbar.CocktailApplication
import com.example.cocktailbar.CocktailViewModel
import com.example.cocktailbar.CocktailViewModelFactory
import com.example.cocktailbar.R
import com.example.cocktailbar.databinding.FragmentCocktailDetailsBinding
import com.example.cocktailbar.databinding.FragmentMyCocktailsBinding

class CocktailDetailsFragment : Fragment() {

    private var _binding: FragmentCocktailDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CocktailViewModel by activityViewModels {
        CocktailViewModelFactory(
            (activity?.application as CocktailApplication).database.cocktailItemDao()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCocktailDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }



}