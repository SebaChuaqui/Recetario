package com.example.recetario.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.recetario.Repository.RepositoryRecetas
import com.example.recetario.room.Recetario
import com.example.recetario.room.RecetasDB

class RecetaViewModel(application: Application): AndroidViewModel(application) {

    private val mRepository: RepositoryRecetas
    val mAllRecetas: LiveData<List<Recetario>>

    init {
        val mRecetaDao = RecetasDB.getRecetasDataBase(application).getrecetasDao()
        mRepository = RepositoryRecetas(mRecetaDao)
        mAllRecetas = mRepository.mRecetas
        mRepository.getProductsFromServer()

    }

    fun getOneID(id: String): LiveData<Recetario> {
        return mRepository.getOneById(id)
    }

}