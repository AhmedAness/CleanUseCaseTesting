package mobi.foo.cleanusecase.presentation.coin_details

import mobi.foo.cleanusecase.domain.model.CoinDetails

data class CoinsDetailsState(
    val isLoading: Boolean = false,
    val coinDetails: CoinDetails? = null,
    val error: String = ""
) {}
