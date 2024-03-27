package com.proyecto.pruebatecnicakotlin.di

import com.proyecto.pruebatecnicakotlin.MyApplication
import com.proyecto.pruebatecnicakotlin.data.network.RickAndMortyApi
import com.proyecto.pruebatecnicakotlin.data.repository.PersonsRepository
import com.proyecto.pruebatecnicakotlin.domain.GetPersonsUseCase
import com.proyecto.pruebatecnicakotlin.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(MyApplication::class)
object AppModule {
    @Provides
    fun provideRickAndMortyApi(): RickAndMortyApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RickAndMortyApi::class.java)
    }

    @Provides
    fun provideCharacterRepository(api: RickAndMortyApi): PersonsRepository {
        return PersonsRepository(api)
    }

    @Provides
    fun provideGetCharactersUseCase(repository: PersonsRepository): GetPersonsUseCase {
        return GetPersonsUseCase(repository)
    }

    @Provides
    fun provideMainViewModel(getCharactersUseCase: GetPersonsUseCase): MainViewModel {
        return MainViewModel(getCharactersUseCase)
    }
}