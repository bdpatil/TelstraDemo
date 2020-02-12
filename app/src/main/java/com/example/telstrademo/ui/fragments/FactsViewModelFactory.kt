package net.simplifiedcoding.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.telstrademo.data.repositories.FactsRepository
import com.example.telstrademo.ui.fragments.FactsViewModel

@Suppress("UNCHECKED_CAST")
class FactsViewModelFactory(
    private val repository: FactsRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FactsViewModel(repository) as T
    }

}