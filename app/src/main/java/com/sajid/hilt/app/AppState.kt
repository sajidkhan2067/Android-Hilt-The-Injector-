package com.sajid.hilt.app

sealed class AppState {

    object NotOnboarded: AppState()
    object Onboarded: AppState()

}