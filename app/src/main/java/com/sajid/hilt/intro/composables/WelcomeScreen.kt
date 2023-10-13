package com.sajid.hilt.intro.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sajid.hilt.R
import com.sajid.hilt.app.ui.previews.AllScreenPreview
import com.sajid.hilt.app.ui.theme.AppDrawerExampleTheme
import com.sajid.hilt.intro.IntroNavOption

@Composable
fun WelcomeScreen(navController: NavController = rememberNavController()) = IntroCompose(
    navController = navController,
    text = stringResource(R.string.welcome_to_the_hilt_injector),
    showBackButton = false
) {
    navController.navigate(IntroNavOption.RecommendationScreen.name)
}


@AllScreenPreview
@Composable
fun WelcomeScreenPreview() {
    AppDrawerExampleTheme {
        WelcomeScreen()
    }
}

