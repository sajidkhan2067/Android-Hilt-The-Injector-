package com.sajid.hilt.app.ui.components.appbar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class AppBarAction(
    @DrawableRes val icon: Int,       // The resource ID of the icon to display
    @StringRes val description: Int,  // The resource ID of the description text
    val onClick: () -> Unit          // The action to execute when clicked, provided as a lambda
)
