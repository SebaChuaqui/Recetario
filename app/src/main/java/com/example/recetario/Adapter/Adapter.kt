package com.example.recetario.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recetario.R
import com.example.recetario.room.Recetario
import kotlinx.android.synthetic.main.recetas.view.*

class Adapter(var mPassRecetas: PassRecetas ): RecyclerView.Adapter<Adapter.ViewHolderProducts>() {

    private var dataList = emptyList<Recetario>()

    fun updateListRecetas(mDataList: List<Recetario>){

        dataList = mDataList
        notifyDataSetChanged()
    }

    inner class ViewHolderProducts(itemView: View): RecyclerView.ViewHolder(itemView){

        val mimg = itemView.img
        val mnombreReceta = itemView.nombrereceta
        // val mingredientes = itemView.ingredientes
        // val mpreparacion = itemView.preparacion
        // val mrecomendacion = itemView.recomendacion
        val itemView = itemView.setOnClickListener{

            mPassRecetas.passRecetas(dataList[adapterPosition])
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderProducts {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recetas, parent, false)
        return ViewHolderProducts(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderProducts, position: Int) {

        val recetas1: Recetario = dataList[position]
        holder.mnombreReceta.text = recetas1.nombreReceta
        Glide.with(holder.itemView.context)
                .load(recetas1.img)
                .into(holder.mimg)

    }

    override fun getItemCount() = dataList.size

}


interface PassRecetas{

    fun passRecetas(mRecetario: Recetario )
}