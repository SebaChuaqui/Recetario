package com.example.recetario.room
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "recetas_table")
data class Recetario(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("img")
    val img: String,
    @SerializedName("Ingredientes")
    val ingredientes: String,
    @SerializedName("Nombre Receta")
    val nombreReceta: String,
    @SerializedName("Preparacion")
    val preparacion: String,
    @SerializedName("Recomendacion")
    val recomendacion: String
)