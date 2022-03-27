package com.example.currencylist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencylist.api.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class ValuteViewModel : ViewModel() {

    val itemsValutes = MutableLiveData<Map<String, Valute>>()
    private val api = RetrofitFactory.new()
    private var job: Job? = null

    fun request() {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            val valutes = api.getTickets()
            itemsValutes.postValue(valutes.valute)
        }

    }

}