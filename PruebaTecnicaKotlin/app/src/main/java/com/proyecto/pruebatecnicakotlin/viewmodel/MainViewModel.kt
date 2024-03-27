package com.proyecto.pruebatecnicakotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proyecto.pruebatecnicakotlin.data.model.Persons
import com.proyecto.pruebatecnicakotlin.domain.GetPersonsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getPersonsUseCase: GetPersonsUseCase) : ViewModel() {

    private val _persons = MutableLiveData<List<Persons>>()
    val persons: LiveData<List<Persons>> = _persons

    fun fetchPersons(page: Int) {
        viewModelScope.launch {
            _persons.value = getPersonsUseCase.execute(page)
        }
    }
}
