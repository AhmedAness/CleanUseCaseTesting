package mobi.foo.cleanusecase.presentation.coins

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import mobi.foo.cleanusecase.presentation.ScreenRoutes

@Composable
fun CoinsScreen(navController: NavHostController, viewModel: CoinsViewModel = hiltViewModel()) {

    val state = viewModel.vmState.value

    Box(modifier = Modifier.fillMaxWidth()) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(state.coins) { coin ->
                CoinsItem(coin = coin, onItemClicked = {
                    navController.navigate(ScreenRoutes.CoinDetailsScreen.route)
                })
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            )
        }

    }


}