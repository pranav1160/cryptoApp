package com.example.cryptocurrency.Presentation.coindetail

import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean=false,
    val coin : CoinDetail? = null,
    val error:String=""
)