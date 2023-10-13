package com.sajid.hilt.app

sealed class AppEvent {

    object FinishOnboarding: AppEvent()
    object SendMail: AppEvent()

}