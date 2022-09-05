package com.example.cocktail.repository

import com.example.cocktail.network.RetrofitService
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class MainRepository @Inject constructor(private val retrofitService: RetrofitService){
    suspend fun getAllDrinkAPI() = retrofitService.getDrinkListService()

}