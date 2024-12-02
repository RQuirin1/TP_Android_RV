package com.example.app_recycledview.retrofit


import com.example.app_recycledview.models.Etudiant

import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET("01f7fecc-a8f1-4c30-9f56-e95f4c47183c")
    suspend fun getAllEtudiants(): Response<ArrayList<Etudiant>>
}