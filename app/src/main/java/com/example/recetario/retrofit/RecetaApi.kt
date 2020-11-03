package com.example.recetario.retrofit

import com.example.recetario.room.Recetario
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RecetaApi {

    @GET("recetario")

    fun fetchAllRecetas(): Call<List<Recetario>>

    @GET("recetario")

    fun fetchAllRecetasCoroutines(): Response<List<Recetario>>
}