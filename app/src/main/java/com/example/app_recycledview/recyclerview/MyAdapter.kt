package com.example.app_recycledview.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_recycledview.databinding.ItemEtudiantBinding
import com.example.app_recycledview.models.Etudiant

class MyAdapter(private val lesEtudiants:ArrayList<Etudiant>, private val onItemClick:(Etudiant)->Unit) : RecyclerView.Adapter<MyHolder>(){

    private lateinit var binding:ItemEtudiantBinding


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyHolder {
        binding = ItemEtudiantBinding.inflate(LayoutInflater.from(parent.context))
        return MyHolder(binding)
    }

    override fun getItemCount(): Int {
        return lesEtudiants.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(lesEtudiants.get(position))

        holder.itemView.setOnClickListener {
            onItemClick(lesEtudiants.get(position))
        }
    }


}