package com.men.cryptocleancompose.domain.repositories

import com.men.cryptocleancompose.data.remote.dto.CoinDTO
import com.men.cryptocleancompose.data.remote.dto.CoinDetailDTO

interface CoinRepository {

    suspend fun getCoins(): List<CoinDTO>

    suspend fun getCoinById(coinId:String): CoinDetailDTO

}