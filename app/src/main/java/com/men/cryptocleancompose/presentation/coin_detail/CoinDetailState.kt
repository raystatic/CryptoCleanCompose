package com.men.cryptocleancompose.presentation.coin_detail

import com.men.cryptocleancompose.domain.model.Coin
import com.men.cryptocleancompose.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading:Boolean = false,
    val coin:CoinDetail?=null,
    val error:String = ""
)
