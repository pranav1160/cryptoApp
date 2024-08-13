package com.example.cryptocurrency

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.core.view.WindowCompat
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cryptocurrency.Presentation.coindetail.CoinDetailScreen
import com.example.cryptocurrency.Presentation.coinslistscreen.CoinListScreen
import com.example.cryptocurrency.navigation.Screen
import com.example.cryptocurrency.ui.theme.CryptocurrencyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            CryptocurrencyTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route,
                            arguments = listOf(navArgument("coinId") { type = NavType.StringType })
                        ) { backStackEntry ->
                            // Retrieve the coinId from the arguments and pass it to the screen
                            val coinId = backStackEntry.arguments?.getString("coinId") ?: ""
                            CoinDetailScreen(coinId = coinId)
                        }
                    }
                }
            }
        }
    }
}
