package com.example.cocktailbar.data

import android.content.ClipData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CocktailItemDao {

    @Query("SELECT * from cocktailitem ORDER BY name ASC")
    fun getCocktailItems(): Flow<List<CocktailItem>>

    @Query("SELECT * from cocktailitem WHERE id = :id")
    fun getItem(id: Int): Flow<CocktailItem>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cocktailItem: CocktailItem)

    @Update
    suspend fun update(cocktailItem: CocktailItem)

    @Delete
    suspend fun delete(cocktailItem: CocktailItem)

}