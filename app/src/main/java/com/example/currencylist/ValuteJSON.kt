package com.example.currencylist

import com.example.currencylist.Valute
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ValuteJSON(
    @SerializedName("Date")
    val date: String,
    @SerializedName("PreviousDate")
    val previousDate: String,
    @SerializedName("PreviousURL")
    val previousURL: String,
    @SerializedName("Timestamp")
    val timestamp: String,
    @SerializedName("Valute")
    val valute: Map<String, Valute>
)