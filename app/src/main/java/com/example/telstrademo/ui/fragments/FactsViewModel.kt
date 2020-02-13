package com.example.telstrademo.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.telstrademo.data.models.Facts
import com.example.telstrademo.data.repositories.FactsRepository
import com.example.telstrademo.utils.Coroutines
import kotlinx.coroutines.Job

class FactsViewModel(
    private val repository: FactsRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _facts = MutableLiveData<List<Facts>>()
    val facts: LiveData<List<Facts>>
        get() = _facts

    fun getFactsData(){
        job =Coroutines.ioThenMain(
            {
                repository.getFacts()
            },
            {
                _facts.value=it
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}
