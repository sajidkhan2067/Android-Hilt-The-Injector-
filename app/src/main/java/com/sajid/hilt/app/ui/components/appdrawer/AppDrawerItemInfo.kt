package com.sajid.hilt.app.ui.components.hiltexample

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class AppDrawerItemInfo<T>(
    val drawerOption: T,                // The drawer option, typically representing a screen or destination.
    @StringRes val title: Int,          // The resource ID for the title displayed in the drawer item.
    @DrawableRes val drawableId: Int,   // The resource ID for the icon (drawable) associated with the drawer item.
    @StringRes val descriptionId: Int   // The resource ID for the description (if any) of the drawer item.
)
