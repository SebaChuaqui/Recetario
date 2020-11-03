package com.example.recetario.retrofit

import com.example.recetario.room.Recetario
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RecetaApi {

    @GET("db.json")

    fun fetchAllRecetas(): Call<List<Recetario>>

    @GET("db.json")

    fun fetchAllRecetasCoroutines(): Response<List<Recetario>>
}