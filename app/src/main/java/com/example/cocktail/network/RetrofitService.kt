package com.example.cocktail.network

import com.example.cocktail.model.Cocktails
import com.example.cocktail.model.Drink
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET(APIendpoint.API_COCKTAIL_LIST)
    suspend fun  getDrinkListService(): Response<Cocktails>

    //companion object{
      //  var retrofitService: RetrofitService?=null

        //fun getRetrofitInstance(): RetrofitService{
          //  if(retrofitService ==null){
            //    val retrofit = Retrofit.Builder()
              //      .baseUrl(APIendpoint.BASE_URL)
                //    .addConverterFactory(GsonConverterFactory.create())
                  //  .build()
                //retrofitService = retrofit.create(RetrofitService::class.java)

            //}
            //return retrofitService!!
       // }
    //}

}