package com.proyecto.pruebatecnicakotlin.data.repository

import com.proyecto.pruebatecnicakotlin.data.model.Persons
import com.proyecto.pruebatecnicakotlin.data.network.RickAndMortyApi

// Definicion de repositorio para obtener los datos del API
class PersonsRepository(private val api: RickAndMortyApi) {
    suspend fun getPersons(page: Int): List<Persons> {
        return api.getPersons(page).results
    }
}