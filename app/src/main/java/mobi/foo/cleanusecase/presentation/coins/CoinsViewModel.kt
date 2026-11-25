package mobi.foo.cleanusecase.presentation.coins

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import mobi.foo.cleanusecase.common.Resource
import mobi.foo.cleanusecase.domain.usecases.CoinUseCase

@HiltViewModel
class CoinsViewModel @Inject constructor(private val useCase: CoinUseCase) : ViewModel() {

    private val _vmState = mutableStateOf(CoinsListState())
    val vmState: State<CoinsListState> = _vmState

    init {
        getCoins()
    }

    private fun getCoins() {
        useCase.invoke().onEach {
            when (it) {
                is Resource.Loading -> {
                    _vmState.value = CoinsListState(isLoading = true)
                }

                is Resource.Success -> {
                    _vmState.value = CoinsListState(coins = it.data ?: emptyList())
                }

                is Resource.Error -> {
                    _vmState.value = CoinsListState(error = it.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }

}