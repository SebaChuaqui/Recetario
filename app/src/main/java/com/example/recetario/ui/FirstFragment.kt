package com.example.recetario.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.products.R
import com.example.recetario.Adapter.Adapter
import com.example.recetario.Adapter.PassRecetas
import com.example.recetario.ViewModel.RecetaViewModel
import com.example.recetario.room.Recetario
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment(), PassRecetas {

    lateinit var mRecetaViewModel: RecetaViewModel
    lateinit var mAdapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRecetaViewModel = ViewModelProvider(this).get(RecetaViewModel::class.java)
        mAdapter = Adapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mProductsRecyclerView = recyclerView

        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        mRecetaViewModel.mAllRecetas.observe(viewLifecycleOwner, Observer {
            mAdapter.updateListRecetas(it)
        })

        //view.findViewById<Button>(R.id.button_first).setOnClickListener {

        // }
    }

    override fun passRecetas(mRecetas: Recetario) {

        val mBundle = Bundle()
        mBundle.putInt("id", mRecetas.id)
        mBundle.putString("img", mRecetas.img)
        mBundle.putString("name", mRecetas.nombreReceta)
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, mBundle)
    }
}

