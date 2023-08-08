package com.example.cocktailbar.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cocktailbar.CocktailApplication
import com.example.cocktailbar.CocktailViewModel
import com.example.cocktailbar.CocktailViewModelFactory
import com.example.cocktailbar.data.CocktailItem
import com.example.cocktailbar.data.CocktailItemDao
import com.example.cocktailbar.databinding.FragmentCocktailCreatingBinding
import com.example.cocktailbar.databinding.FragmentMyCocktailsBinding

class CocktailCreatingFragment : Fragment() {

    private val viewModel: CocktailViewModel by activityViewModels {
        CocktailViewModelFactory(
            (activity?.application as CocktailApplication).database
                .cocktailItemDao()
        )
    }

    private var _binding: FragmentCocktailCreatingBinding? = null
    private val binding get() = _binding!!

    lateinit var item: CocktailItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCocktailCreatingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveButton.setOnClickListener { isEntryValid() }
    }

    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            binding.itemTitleEditText.toString(),
            binding.itemDescriptionEditText.toString(),
            binding.ingredientRecyclerView,
            binding.itemRecipeEditText.toString()
        )
    }

}
