package com.example.cocktail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocktail.model.Cocktails
import com.example.cocktail.model.Drink
import com.example.cocktail.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository):ViewModel() {
    val error = MutableLiveData<String>()
    val respData = MutableLiveData<Cocktails>()
    var job: Job?= null

    fun getDrinkDataFromVM(){
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getAllDrinkAPI()
            withContext(Dispatchers.Main){
                respData.postValue(response.body())
            }
        }
    }
}