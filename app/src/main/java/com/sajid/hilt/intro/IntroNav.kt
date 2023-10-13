package com.sajid.hilt.intro

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.sajid.hilt.NavRoutes
import com.sajid.hilt.app.AppViewModel
import com.sajid.hilt.intro.composables.RecommendationScreen
import com.sajid.hilt.intro.composables.WelcomeScreen

fun NavGraphBuilder.introGraph(navController: NavController) {
    navigation(startDestination = IntroNavOption.WelcomeScreen.name, route = NavRoutes.IntroRoute.name) {
        composable(IntroNavOption.WelcomeScreen.name){
            WelcomeScreen(navController)
        }
        composable(IntroNavOption.RecommendationScreen.name){
            val viewModel: AppViewModel = hiltViewModel()
            RecommendationScreen(navController){
                viewModel.onEvent(it)
            }
        }
    }
}

enum class IntroNavOption {
    WelcomeScreen,
    RecommendationScreen
}
