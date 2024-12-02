package com.example.app_recycledview.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.app_recycledview.MainActivity
import com.example.app_recycledview.R
import com.example.app_recycledview.databinding.FragmentDetailEtudiantsBinding
import com.example.app_recycledview.databinding.ItemEtudiantBinding
import com.example.app_recycledview.models.DataViewModelDetails


class DetailEtudiants : Fragment() {

    private lateinit var binding:FragmentDetailEtudiantsBinding
    private lateinit var viewModelDetailsPartage: DataViewModelDetails

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailEtudiantsBinding.inflate(inflater,container,false)
        viewModelDetailsPartage = ViewModelProvider(requireActivity()).get(DataViewModelDetails::class.java)
        binding.lifecycleOwner = this@DetailEtudiants

        binding.etudiant = viewModelDetailsPartage

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }


}