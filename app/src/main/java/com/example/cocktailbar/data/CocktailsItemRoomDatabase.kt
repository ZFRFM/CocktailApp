package com.example.cocktailbar.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CocktailItem::class], version = 1, exportSchema = false)
abstract class CocktailsItemRoomDatabase: RoomDatabase() {

    abstract fun cocktailItemDao(): CocktailItemDao

    companion object{
        @Volatile
        private var INSTANCE: CocktailsItemRoomDatabase? = null

        fun getDatabase(context: Context): CocktailsItemRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CocktailsItemRoomDatabase::class.java,
                    "item_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

}