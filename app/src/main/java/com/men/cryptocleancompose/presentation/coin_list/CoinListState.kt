package com.men.cryptocleancompose.presentation.coin_list

import com.men.cryptocleancompose.domain.model.Coin

data class CoinListState(
    val isLoading:Boolean = false,
    val coins:List<Coin> = emptyList(),
    val error:String = ""
)
