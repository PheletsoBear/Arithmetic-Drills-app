package com.loc.newsapp.presentation.navigation

import com.loc.newsapp.util.Constants.HomeScreenRoute
import com.loc.newsapp.util.Constants.OnBoardingScreenRoute
import com.loc.newsapp.util.Constants.SessionScreenRoute

sealed class Route (
    val route: String
){
    object OnBoardingScreen : Route(route = OnBoardingScreenRoute)
    object HomeScreen : Route(route = HomeScreenRoute)
    object SessionScreen: Route(route = SessionScreenRoute )
}