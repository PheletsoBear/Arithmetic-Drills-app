package com.loc.newsapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.arithmeticdrills.presentation.home.HomeScreen
import com.example.arithmeticdrills.presentation.onBoarding.OnBoardingScreen
import com.loc.newsapp.data.manager.LocalUserManager


@Composable
fun NavGraph(
    startDestination: String,
    localUserManager: LocalUserManager
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Route.OnBoardingScreen.route) {
            OnBoardingScreen(navController)
        }
        composable(route = Route.HomeScreen.route) {
            HomeScreen(navController)
        }
    }
}