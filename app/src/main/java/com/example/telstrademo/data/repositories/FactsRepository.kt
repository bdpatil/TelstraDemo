package com.example.telstrademo.data.repositories

import com.example.telstrademo.data.networks.FactsApi


class FactsRepository(
    private val api: FactsApi
) : SafeApiRequest() {

    suspend fun getFacts() = apiRequest { api.getFacts() }

}