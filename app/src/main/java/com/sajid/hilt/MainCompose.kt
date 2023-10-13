package com.sajid.hilt

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.sajid.hilt.app.AppState
import com.sajid.hilt.app.ui.components.hiltexample.AppDrawerContent
import com.sajid.hilt.app.ui.components.hiltexample.AppDrawerItemInfo
import com.sajid.hilt.app.ui.theme.AppDrawerExampleTheme
import com.sajid.hilt.intro.introGraph

@Composable
fun MainCompose(
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    appState: AppState,
) {
    // Applying the theme to the entire composition
    AppDrawerExampleTheme {
        // Creating a Surface for the entire UI
        Surface {
            // Defining the Modal Navigation Drawer
            ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
                AppDrawerContent(
                    drawerState = drawerState,
                    menuItems = DrawerParams.drawerButtons,
                    defaultPick = MainNavOption.HomeScreen
                ) { onUserPickedOption ->
                    // Handling user's selection of a menu item
                    when (onUserPickedOption) {
                        MainNavOption.HomeScreen -> {
                            navController.navigate(onUserPickedOption.name) {
                                popUpTo(NavRoutes.MainRoute.name)
                            }
                        }

                        MainNavOption.SettingsScreen -> {
                            navController.navigate(onUserPickedOption.name) {
                                popUpTo(NavRoutes.MainRoute.name)
                            }
                        }

                        MainNavOption.AboutScreen -> {
                            navController.navigate(onUserPickedOption.name) {
                                popUpTo(NavRoutes.MainRoute.name)
                            }
                        }
                    }
                }
            }) {
                // Defining the Navigation Host
                NavHost(
                    navController, startDestination = when (appState) {
                        AppState.NotOnboarded -> NavRoutes.IntroRoute.name
                        AppState.Onboarded -> NavRoutes.MainRoute.name
                    }
                ) {
                    introGraph(navController)
                    mainGraph(drawerState)
                }
            }
        }
    }
}

// Enum to define navigation routes
enum class NavRoutes {
    IntroRoute, MainRoute,
}

// Object to store drawer button parameters
object DrawerParams {
    val drawerButtons = arrayListOf(
        AppDrawerItemInfo(
            MainNavOption.HomeScreen,
            R.string.text_home,
            R.drawable.ic_home,
            R.string.text_home_description
        ), AppDrawerItemInfo(
            MainNavOption.SettingsScreen,
            R.string.text_settings,
            R.drawable.ic_settings,
            R.string.text_settings_description
        ), AppDrawerItemInfo(
            MainNavOption.AboutScreen,
            R.string.text_about,
            R.drawable.ic_info,
            R.string.text_info_description
        )
    )
}

// Preview function for MainActivity
@Preview
@Composable
fun MainActivityPreview() {
    MainCompose(appState = AppState.Onboarded)
}
