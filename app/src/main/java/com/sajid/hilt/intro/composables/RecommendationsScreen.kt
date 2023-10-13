package com.sajid.hilt.intro.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sajid.hilt.NavRoutes
import com.sajid.hilt.R
import com.sajid.hilt.app.AppEvent
import com.sajid.hilt.app.ui.previews.AllScreenPreview

@Composable
fun RecommendationScreen(
    navController: NavController,
    onEvent: (appEvent: AppEvent) -> Unit
) = IntroCompose(
    navController = navController,
    text = stringResource(R.string.recommendation),
    buttonText = R.string.start_app
) {
    onEvent(AppEvent.FinishOnboarding)
    navController.navigate(NavRoutes.MainRoute.name) {
        popUpTo(NavRoutes.IntroRoute.name)
    }
}

@AllScreenPreview
@Composable
fun RecommendationScreenPreview() {
    val navController = rememberNavController()
    RecommendationScreen(navController = navController){}
}