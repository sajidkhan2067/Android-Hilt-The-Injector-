package com.sajid.hilt.intro.repo

import android.util.Log
import javax.inject.Inject

class SettingsRepoImp @Inject constructor(): SettingsRepo {

    private var isOnboardedParam: Boolean = false

    override fun isOnboarded(): Boolean = isOnboardedParam

    override fun saveOnboardingState(isOnboarded: Boolean) {
        Log.i(TAG, "saveOnboardingState: $isOnboarded")
        isOnboardedParam = isOnboarded
    }

    companion object {
        const val TAG = "SettingsRepoImp"
    }
}