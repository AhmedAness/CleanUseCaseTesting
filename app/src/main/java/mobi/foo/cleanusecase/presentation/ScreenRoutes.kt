package mobi.foo.cleanusecase.presentation

sealed class ScreenRoutes(val route: String) {

    data object CoinsScreen : ScreenRoutes("coins_screen")
    data object CoinDetailsScreen : ScreenRoutes("coin_details_screen")

}