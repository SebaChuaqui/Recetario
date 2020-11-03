package com.example.products.model.retrofit

import com.example.recetario.retrofit.RecetaApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {

    companion object{

        private const val URL_BASE = "https://my-json-server.typicode.com/SebaChuaqui/Recetas/"

        fun getRetrofitClient(): RecetaApi {

            val mRetorfit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetorfit.create(RecetaApi::class.java)
        }
    }
}