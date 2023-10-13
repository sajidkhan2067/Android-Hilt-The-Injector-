package com.sajid.hilt.app.ui.components.appbar

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sajid.hilt.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    drawerState: DrawerState? = null,              // Optional parameter for drawer state
    navigationIcon: (@Composable () -> Unit)? = null,  // Optional parameter for navigation icon
    @StringRes title: Int? = null,                   // Optional parameter for the title (as a resource ID)
    appBarActions: List<AppBarAction>? = null       // Optional list of app bar actions
) {
    TopAppBar(
        title = {
            title?.let {
                Text(
                    text = stringResource(id = title),         // Set the title text from the provided resource ID
                    style = MaterialTheme.typography.titleMedium
                )
            }
        },
        actions = {
            appBarActions?.let {
                for (appBarAction in it) {
                    AppBarAction(appBarAction)             // Add each app bar action
                }
            }
        },
        navigationIcon = {
            if (drawerState != null && navigationIcon == null){
                DrawerIcon(drawerState = drawerState)         // Use the drawer icon if available
            } else {
                navigationIcon?.invoke()                      // Otherwise, use the provided navigation icon
            }
        },
    )
}

@Composable
private fun DrawerIcon(drawerState: DrawerState) {
    val coroutineScope = rememberCoroutineScope()
    IconButton(onClick = {
        coroutineScope.launch {
            drawerState.open()                             // Open the drawer when the icon is clicked
        }
    }) {
        Icon(
            Icons.Rounded.Menu,
            tint = MaterialTheme.colorScheme.onBackground,
            contentDescription = stringResource(id = R.string.text_menu_description)
        )
    }
}

@Composable
fun AppBarAction(appBarAction: AppBarAction) {
    IconButton(onClick = appBarAction.onClick) {
        Icon(
            painter = painterResource(id = appBarAction.icon),
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.onBackground,
            contentDescription = stringResource(id = appBarAction.description)
        )
    }
}
