package com.example.app_recycledview

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import com.example.app_recycledview.databinding.ActivityMainBinding
import com.example.app_recycledview.fragment.Main
import com.example.app_recycledview.models.DataViewModel
import com.example.app_recycledview.models.DataViewModelDetails

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var viewmodelPartage:DataViewModel
    private lateinit var viewmodelDetailsPartage:DataViewModelDetails

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        viewmodelPartage = ViewModelProvider(this).get(DataViewModel::class.java)
        viewmodelDetailsPartage = ViewModelProvider(this).get(DataViewModelDetails::class.java)


        remplaceFragment(binding.fragmentContainer, Main())

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


    }



    fun remplaceFragment(fragmentContainerView: FragmentContainerView, fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(fragmentContainerView.id, fragment)
        fragmentTransaction.commit()


    }
}