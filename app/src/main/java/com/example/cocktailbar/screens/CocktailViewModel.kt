package com.example.cocktailbar.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cocktailbar.data.CocktailItem
import com.example.cocktailbar.data.CocktailItemDao
import kotlinx.coroutines.flow.Flow

class CocktailViewModel(private val itemDao: CocktailItemDao): ViewModel() {

    fun getCocktailItemsList(): Flow<List<CocktailItem>> = itemDao.getCocktailItems()
    fun getCocktailItem(id: Int): Flow<CocktailItem> = itemDao.getItem(id)

    fun isEntryValid(title: String, description: String, recipe: String): Boolean {
        if (title.isBlank()) {
            return false
        }
        return true
    }
}

class CocktailViewModelFactory(private val itemDao: CocktailItemDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CocktailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CocktailViewModel(itemDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}