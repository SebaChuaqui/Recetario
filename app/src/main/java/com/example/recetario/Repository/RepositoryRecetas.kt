package com.example.recetario.Repository

import android.util.Log
import androidx.lifecycle.LiveData

import com.example.products.model.retrofit.RetrofitClient
import com.example.recetario.room.RecetaDao
import com.example.recetario.room.Recetario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryRecetas(private val mRecetaDao: RecetaDao) {

    private val service = RetrofitClient.getRetrofitClient()

    val mRecetas = mRecetaDao.getAllRecetasFromDB()
    val mrecetasDBList = mutableListOf<Recetario>()

    fun getProductsFromServer() {

        val mCall = service.fetchAllRecetas()
        mCall.enqueue(object : Callback<List<Recetario>> {
            override fun onResponse(
                call: Call<List<Recetario>>,
                response: Response<List<Recetario>>
            ) {
                Log.d("Prueba", response.body().toString())
                when (response.code()) {

                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        response.body()?.let {
                            Log.d("productos", it.toString())
                            mRecetaDao.insertAllRecetas(it)
                        }
                    }

                    in 300..399 -> Log.d("Error 300", response.errorBody().toString())
                    in 400..499 -> Log.d("Error 400", response.errorBody().toString())
                    in 500..599 -> Log.d("Error 500", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<List<Recetario>>, t: Throwable) {
                Log.d("error", t.message.toString())
            }

        })
    }

    fun getOneById(id: String): LiveData<Recetario> {
        return mRecetaDao.getCodigoByID(id)
    }
}

