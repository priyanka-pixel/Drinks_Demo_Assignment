package com.example.cocktail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocktail.adapter.Drinkadapter
import com.example.cocktail.databinding.ActivityMainBinding
import com.example.cocktail.model.Drink
import com.example.cocktail.network.RetrofitService
import com.example.cocktail.repository.MainRepository
import com.example.cocktail.viewmodel.MainViewModel
import com.example.cocktail.viewmodel.MyViewModelFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //private lateinit var viewModel: MainViewModel
    private val viewModel by viewModels<MainViewModel>()

    private lateinit var activityBinding: ActivityMainBinding
    private val drinkable = Drinkadapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)

        activityBinding.recyclerView.adapter = drinkable
        activityBinding.recyclerView.layoutManager = LinearLayoutManager(this)


        initializeService()
        callService()
        getDataToDisplay()
    }
    fun initializeService(){
        //val retrofitService = RetrofitService.getRetrofitInstance()
        //val repository = MainRepository(retrofitService)
        //viewModel = ViewModelProvider(this,MyViewModelFactory(repository)).get(MainViewModel::class.java)

    }
    fun callService(){
        viewModel.getDrinkDataFromVM()

    }
    fun getDataToDisplay(){
        viewModel.respData.observe(this){
            //Log.i("Drink", it)
            drinkable.submitList(it.drinks)
        }

    }
}