package com.men.cryptocleancompose.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.men.cryptocleancompose.common.Constants
import com.men.cryptocleancompose.common.Resource
import com.men.cryptocleancompose.domain.usecases.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    private val savedStateHandle: SavedStateHandle
):ViewModel(){

    private val _state = mutableStateOf(CoinDetailState())
    val state:State<CoinDetailState> get() = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId:String){
        getCoinUseCase(coinId = coinId).onEach { result->
            when(result){
                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = result.data)
                }

                is Resource.Error -> {
                    _state.value = CoinDetailState(
                        error = result.message ?: "An unknown error"
                    )
                }

                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}