package com.men.cryptocleancompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.men.cryptocleancompose.presentation.coin_detail.components.CoinDetailScreen
import com.men.cryptocleancompose.presentation.coin_list.components.CoinListScreen
import com.men.cryptocleancompose.presentation.ui.theme.CryptoCleanComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCleanComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ){
                        composable(
                            route = Screen.CoinListScreen.route
                        ){
                            CoinListScreen(navController = navController)
                        }

                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coin_id}"
                        ){
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
