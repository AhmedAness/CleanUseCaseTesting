package mobi.foo.cleanusecase.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mobi.foo.cleanusecase.presentation.coin_details.CoinDetailsScreen
import mobi.foo.cleanusecase.presentation.coins.CoinsScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenRoutes.CoinsScreen.route){
        composable(ScreenRoutes.CoinsScreen.route) {
            CoinsScreen(navController)
        }
        composable(ScreenRoutes.CoinDetailsScreen.route) {
            CoinDetailsScreen(navController)
        }
    }
}