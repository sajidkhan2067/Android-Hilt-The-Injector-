package com.sajid.hilt.intro.repo

interface SettingsRepo {

    fun isOnboarded(): Boolean
    fun saveOnboardingState(isOnboarded: Boolean)

}