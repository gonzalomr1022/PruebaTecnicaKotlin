package com.proyecto.pruebatecnicakotlin.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import com.proyecto.pruebatecnicakotlin.data.model.Persons
import com.proyecto.pruebatecnicakotlin.viewmodel.MainViewModel

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
    val persons by viewModel.persons.observeAsState(initial = emptyList())
    val selectedCharacter = remember { mutableStateOf<Persons?>(null) }

    Column {
        persons.forEach { persons ->
            PersonsItem(persons = persons) {
                selectedCharacter.value = persons
            }
        }

        selectedCharacter.value?.let { persons ->
            PersonsDetail(persons = persons)
        }
    }
}


@Composable
fun PersonsItem(persons: Persons, onDetailClick: () -> Unit) {
    // Muestra la imagen y el nombre del personaje
    Column {
        Image(
            painter = rememberImagePainter(persons.image),
            contentDescription = "Character Image",
            //modifier = Modifier.size(100.dp)
        )
        Text(text = persons.name)
        Button(onClick = onDetailClick) {
            Text("Ver detalle")
        }
    }
}

fun rememberImagePainter(image: String): Painter {
    return rememberImagePainter(image)
}

@Composable
fun PersonsDetail(persons: Persons) {
    // Muestra los detalles del personaje aquí
    Text("Status: ${persons.status}")
    Text("Species: ${persons.species}")
    Text("Type: ${persons.type}")
    Text("Gender: ${persons.gender}")
    Text("Origin: ${persons.origin.name}")
    Text("Location: ${persons.location.name}")
}

