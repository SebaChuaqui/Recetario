package com.example.recetario.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RecetaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRecetas(mRecetaList: List<Recetario>)

    @Query("SELECT * FROM recetas_table")
    fun getAllRecetasFromDB(): LiveData<List<Recetario>>

    @Query("SELECT * FROM recetas_table WHERE id=:id")
    fun getCodigoByID(id: String): LiveData<Recetario>


}