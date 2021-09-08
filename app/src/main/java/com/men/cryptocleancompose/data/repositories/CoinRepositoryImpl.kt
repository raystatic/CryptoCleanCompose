package com.men.cryptocleancompose.data.repositories

import com.men.cryptocleancompose.data.remote.ApiService
import com.men.cryptocleancompose.data.remote.dto.CoinDTO
import com.men.cryptocleancompose.data.remote.dto.CoinDetailDTO
import com.men.cryptocleancompose.domain.repositories.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): CoinRepository {

    override suspend fun getCoins(): List<CoinDTO> {
        return apiService.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDTO {
        return apiService.getCoinById(coinId)
    }
}