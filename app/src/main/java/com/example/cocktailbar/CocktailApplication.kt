package com.example.cocktailbar

import android.app.Application
import com.example.cocktailbar.database.CocktailsItemRoomDatabase

class CocktailApplication: Application() {
    val database: CocktailsItemRoomDatabase by lazy { CocktailsItemRoomDatabase.getDatabase(this) }
}