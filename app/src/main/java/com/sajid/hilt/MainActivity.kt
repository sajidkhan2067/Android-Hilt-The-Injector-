package com.sajid.hilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.sajid.hilt.app.AppViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint // Marks this class as eligible for Hilt's dependency injection
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content of this activity using Jetpack Compose
        setContent {
            // Create an instance of the AppViewModel using Hilt's view model injection
            val vm: AppViewModel = hiltViewModel()

            // Collect the isOnboarded state from the view model and represent it as a state
            val isOnboardedState = vm.isOnboarded.collectAsState()

            // Launch the MainCompose composable, passing the isOnboarded state as an argument
            MainCompose(appState = isOnboardedState.value)
        }
    }
}


