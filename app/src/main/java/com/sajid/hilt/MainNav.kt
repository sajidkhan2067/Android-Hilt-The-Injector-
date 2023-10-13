package com.sajid.hilt

import androidx.compose.material3.DrawerState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.sajid.hilt.about.AboutScreen
import com.sajid.hilt.app.AppViewModel
import com.sajid.hilt.home.HomeScreen
import com.sajid.hilt.settings.SettingsScreen

fun NavGraphBuilder.mainGraph(drawerState: DrawerState) {
    // Define the main navigation graph with the start destination and route
    navigation(startDestination = MainNavOption.HomeScreen.name, route = NavRoutes.MainRoute.name) {
        // Composable for the HomeScreen
        composable(MainNavOption.HomeScreen.name) {
            // Initialize the AppViewModel using Hilt's hiltViewModel function
            val viewModel: AppViewModel = hiltViewModel()
            // Render the HomeScreen composable, passing the drawerState and event handler
            HomeScreen(drawerState) { event ->
                viewModel.onEvent(event)
            }
        }
        // Composable for the SettingsScreen
        composable(MainNavOption.SettingsScreen.name) {
            // Render the SettingsScreen composable, passing the drawerState
            SettingsScreen(drawerState)
        }
        // Composable for the AboutScreen
        composable(MainNavOption.AboutScreen.name) {
            // Render the AboutScreen composable, passing the drawerState
            AboutScreen(drawerState)
        }
    }
}

// Define an enum class to represent the main navigation options
enum class MainNavOption {
    HomeScreen,     // Represents the HomeScreen option
    AboutScreen,    // Represents the AboutScreen option
    SettingsScreen  // Represents the SettingsScreen option
}
