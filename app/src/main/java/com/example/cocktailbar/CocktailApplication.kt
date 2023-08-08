package com.example.cocktailbar

import android.app.Application
import com.example.cocktailbar.data.CocktailsItemRoomDatabase

class CocktailApplication: Application() {
    val database: CocktailsItemRoomDatabase by lazy { CocktailsItemRoomDatabase.getDatabase(this) }
}