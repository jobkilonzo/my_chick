package com.example.mychick.kuroiler

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class KuroilerViewModel(private val repository: KuroilerRepository): ViewModel() {

    val allCost: LiveData<List<KuroilerCost>> = repository.allCost.asLiveData()

    val cost: LiveData<Int> = repository.cost.asLiveData()

    fun insert(kuroilerCost: KuroilerCost) = viewModelScope.launch{
        repository.insert(kuroilerCost)
    }
}

class KuroilerViewmodelFactory(private val repository: KuroilerRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(KuroilerViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return KuroilerViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}