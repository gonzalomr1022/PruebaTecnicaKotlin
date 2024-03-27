package com.proyecto.pruebatecnicakotlin.data.network

import com.proyecto.pruebatecnicakotlin.data.model.Persons

// Define la clase ApiResponse para mapear la respuesta del API
data class ApiResponse(
    val results: List<Persons>
)