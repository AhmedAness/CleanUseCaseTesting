package mobi.foo.cleanusecase.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import mobi.foo.cleanusecase.common.Constants
import mobi.foo.cleanusecase.common.Resource
import mobi.foo.cleanusecase.domain.usecases.CoinDetailsUseCase

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val useCase: CoinDetailsUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    private val _vmState = mutableStateOf(CoinsDetailsState())
    val vmState: State<CoinsDetailsState> = _vmState

    init {
        savedStateHandle.get<String>(Constants.COIN_ID)?.let {
            getCoinDetails(it)
        }
    }

    private fun getCoinDetails(coinId: String) {
        useCase.invoke(coinId).onEach {
            when (it) {
                is Resource.Loading -> {
                    _vmState.value = CoinsDetailsState(isLoading = true)
                }

                is Resource.Success -> {
                    _vmState.value = CoinsDetailsState(coinDetails = it.data)
                }

                is Resource.Error -> {
                    _vmState.value = CoinsDetailsState(error = "")
                }
            }
        }.launchIn(viewModelScope)
    }

}