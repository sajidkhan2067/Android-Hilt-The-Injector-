package com.sajid.hilt.app

import androidx.lifecycle.ViewModel
import com.sajid.hilt.intro.repo.MailClient
import com.sajid.hilt.intro.repo.SettingsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class AppViewModel @Inject constructor(
    private val settingsRepo: SettingsRepo, private val mailClient: MailClient
) : ViewModel() {

    // Create a MutableStateFlow to hold the app's onboarding state
    private val _isOnboarded: MutableStateFlow<AppState> = MutableStateFlow(AppState.NotOnboarded)

    // Create a public StateFlow to expose the onboarding state to other components
    var isOnboarded = _isOnboarded.asStateFlow()

    init {
        // Initialize the onboarding state based on data from the settings repository
        _isOnboarded.value =
            if (settingsRepo.isOnboarded()) AppState.Onboarded else AppState.NotOnboarded
    }

    fun onEvent(appEvent: AppEvent) = when (appEvent) {
        AppEvent.FinishOnboarding -> saveUserOnboarding()
        AppEvent.SendMail -> sendMail()
    }

    // Save the user's onboarding state and update the MutableStateFlow
    private fun saveUserOnboarding() {
        _isOnboarded.value = AppState.Onboarded
        settingsRepo.saveOnboardingState(true)
    }

    // Use the mail client to send an email
    private fun sendMail() = mailClient.sendMail()

}
