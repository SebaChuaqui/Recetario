package com.example.recetario.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


private const val DATA_BASE_NAME="recetas_db"

@Database(entities = [Recetario::class], version = 1)


abstract class RecetasDB: RoomDatabase() {

    abstract fun getrecetasDao(): RecetaDao

    companion object{

        @Volatile

        private var INSTANCE: RecetasDB? = null

        fun getRecetasDataBase(context: Context): RecetasDB {

            val tempInterface = INSTANCE
            if(tempInterface != null){
                return tempInterface
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    RecetasDB::class.java,
                    DATA_BASE_NAME
                )
                    .build()
                INSTANCE = instance
                return instance
            }

        }
    }

}
