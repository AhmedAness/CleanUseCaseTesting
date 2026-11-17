package mobi.foo.cleanusecase.presentation.coin_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import mobi.foo.cleanusecase.presentation.ScreenRoutes

@Composable
fun CoinDetailsScreen(navController: NavHostController) {
    Column {
        Text(text = "welcome to coin Details screen")
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            navController.navigate(ScreenRoutes.CoinsScreen.route){
                popUpTo(ScreenRoutes.CoinsScreen.route){
                    inclusive = true
                }
            }
        }) {
            Text(text = "Navigate to Coins Screen")
        }
    }
}