package com.example.app_recycledview.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.app_recycledview.databinding.ItemEtudiantBinding
import com.example.app_recycledview.models.Etudiant

class MyHolder(private val binding:ItemEtudiantBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(etudiant: Etudiant){
        binding.etudiant = etudiant
    }

}