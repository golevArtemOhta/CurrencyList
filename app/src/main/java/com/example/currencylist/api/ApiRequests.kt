package com.example.currencylist.api

import com.example.currencylist.ValuteJSON
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiRequests {
    @GET("/daily_json.js")
    suspend fun getTickets(): ValuteJSON
}
