package com.example.telstrademo.data.repositories

import com.example.telstrademo.data.networks.FactsApi
import retrofit2.Response
import retrofit2.http.GET


class FactsRepository(
    private val api: FactsApi
) : SafeApiRequest() {

    suspend fun getFacts() = apiRequest { api.getFacts() }


}