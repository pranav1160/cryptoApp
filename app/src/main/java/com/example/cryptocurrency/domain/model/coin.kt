package com.example.cryptocurrency.domain.model

import com.google.gson.annotations.SerializedName

data class Coin (
    val id: String,
    val isActive:Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,

)
//when we want to extract the main parameters of this data class we usually use mapper

