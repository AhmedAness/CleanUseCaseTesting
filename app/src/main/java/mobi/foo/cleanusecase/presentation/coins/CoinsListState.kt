package mobi.foo.cleanusecase.presentation.coins

import mobi.foo.cleanusecase.domain.model.Coin

data class CoinsListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
