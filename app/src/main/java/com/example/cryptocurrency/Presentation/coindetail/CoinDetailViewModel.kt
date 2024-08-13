package com.example.cryptocurrency.Presentation.coindetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrency.Common.Constants
import com.example.cryptocurrency.Common.Resources
import com.example.cryptocurrency.domain.usecases.singlecoin.SingleCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: SingleCoinUseCase,
    private val savedstatehandle :SavedStateHandle
): ViewModel(){

    private val _state= mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init{
        savedstatehandle.get<String>(Constants.PARAM_COIN_ID)
    }
    private fun getCoins(coinId:String){
        getCoinUseCase(coinId).onEach {result->
            when(result){
                is Resources.Success->{
                    _state.value= CoinDetailState(coin = result.data ?: null)
                }
                is Resources.Error->{
                    _state.value = CoinDetailState(
                        error = result.message ?:"An unexpected error"
                    )
                }
                is Resources.Loading->{
                    _state.value= CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}