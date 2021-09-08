package com.men.cryptocleancompose.domain.usecases.get_coin

import com.men.cryptocleancompose.common.Resource
import com.men.cryptocleancompose.data.remote.dto.toCoin
import com.men.cryptocleancompose.data.remote.dto.toCoinDetail
import com.men.cryptocleancompose.domain.model.Coin
import com.men.cryptocleancompose.domain.model.CoinDetail
import com.men.cryptocleancompose.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
){

    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unknown Error"))
        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection"))
        }
    }
}