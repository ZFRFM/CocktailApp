package com.example.cocktailbar.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailbar.CocktailApplication
import com.example.cocktailbar.CocktailViewModel
import com.example.cocktailbar.CocktailViewModelFactory
import com.example.cocktailbar.R
import com.example.cocktailbar.adapters.MyCocktailsAdapter
import com.example.cocktailbar.databinding.FragmentMyCocktailsBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MyCocktailsFragment : Fragment() {

    private var _binding: FragmentMyCocktailsBinding? = null

    private val binding get() = _binding!!

    private val viewModel: CocktailViewModel by activityViewModels {
        CocktailViewModelFactory(
            (activity?.application as CocktailApplication).database.cocktailItemDao()
        )
    }

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MyCocktailsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyCocktailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.cocktailsRecyclerView
        adapter = MyCocktailsAdapter {
            val action = MyCocktailsFragmentDirections.actionMyCocktailsToCocktailDetails(
                id = it.id
            )
            view.findNavController().navigate(action)
        }

        GlobalScope.launch(Dispatchers.IO) {
            //adapter.submitList(viewModel.getCocktailItemsList())
        }

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_myCocktails_to_cocktailCreating)
        }
    }

}