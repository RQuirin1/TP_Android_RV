package com.example.app_recycledview.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_recycledview.R
import com.example.app_recycledview.databinding.FragmentMainBinding
import com.example.app_recycledview.models.DataViewModel
import com.example.app_recycledview.models.DataViewModelDetails
import com.example.app_recycledview.models.Etudiant
import com.example.app_recycledview.recyclerview.MyAdapter
import com.example.app_recycledview.retrofit.ApiAdapteur
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class Main : Fragment(R.layout.fragment_main) {

    private lateinit var binding : FragmentMainBinding
    private lateinit var viewmodelPartage:DataViewModel
    private lateinit var viewmodelPartageDetails: DataViewModelDetails


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewmodelPartage = ViewModelProvider(requireActivity()).get(DataViewModel::class.java)
        viewmodelPartageDetails = ViewModelProvider(requireActivity()).get(DataViewModelDetails::class.java)

        binding = FragmentMainBinding.inflate(layoutInflater,container,false)

        viewmodelPartageDetails.initData()
        viewmodelPartage.initData()
        miseAJour()

        return binding.root
    }

    private fun miseAJour(){
        GlobalScope.launch(Dispatchers.Main) {
            val listeEtudiant = ApiAdapteur.apiClient.getAllEtudiants()
            if (listeEtudiant.isSuccessful){
                listeEtudiant.body()?.let {arEtudiants ->
                    viewmodelPartage.updateData(arEtudiants)
                    binding.rvEtudiants.adapter = MyAdapter(viewmodelPartage.data.value!!){etudiant ->
                        viewmodelPartageDetails.updateData(etudiant)
                        Log.i("m",viewmodelPartageDetails.getData().toString())
                        afficheDetails()
                    }

                    binding.rvEtudiants.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
                }
            }
        }
    }

    private fun afficheDetails() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, DetailEtudiants())
            .addToBackStack(null)
            .commit()
    }
}