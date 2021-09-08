package com.men.cryptocleancompose.data.remote

import com.men.cryptocleancompose.data.remote.dto.CoinDTO
import com.men.cryptocleancompose.data.remote.dto.CoinDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/v1/coins")
    suspend fun getCoins():List<CoinDTO>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId")coinId:String): CoinDetailDTO

}