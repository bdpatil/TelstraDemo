package com.example.telstrademo.data.networks
import com.example.telstrademo.data.models.Facts
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface FactsApi {
//Here we are calling out api
    @GET("/s/2iodh4vg0eortkl/facts.json")
    suspend fun getFacts(): Response<Facts>

    companion object {
        operator fun invoke(): FactsApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://dl.dropboxusercontent.com")//base url
                .build()
                .create(FactsApi::class.java)
        }
    }
}

