package com.proyecto.pruebatecnicakotlin.domain

import com.proyecto.pruebatecnicakotlin.data.model.Persons
import com.proyecto.pruebatecnicakotlin.data.repository.PersonsRepository

// Define el caso de uso para obtener los personajes
class GetPersonsUseCase(private val repository: PersonsRepository) {
    suspend fun execute(page: Int): List<Persons> {
        return repository.getPersons(page)
    }
}