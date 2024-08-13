// In your navigation package, define your screens
package com.example.cryptocurrency.navigation

sealed class Screen(val route: String) {
    object CoinListScreen : Screen("coin_list_screen")
    object CoinDetailScreen : Screen("coin_detail_screen/{coinId}") {
        fun createRoute(coinId: String) = "coin_detail_screen/$coinId"
    }
}
