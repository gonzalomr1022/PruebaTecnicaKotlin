package com.proyecto.pruebatecnicakotlin.data.network

import retrofit2.http.GET
import retrofit2.http.Query

// Define la interfaz Retrofit para obtener los datos del API
interface RickAndMortyApi {
    @GET("character")
    suspend fun getPersons(@Query("page") page: Int): ApiResponse
}