package com.example.recetario.pojo

import com.example.recetario.room.Recetario
import com.google.gson.annotations.SerializedName

data class Receta(
    @SerializedName("recetario")
    val recetario: List<Recetario>
)