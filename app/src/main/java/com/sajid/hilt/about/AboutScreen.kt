package com.sajid.hilt.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.sajid.hilt.R
import com.sajid.hilt.app.ui.components.appbar.AppBar
import com.sajid.hilt.app.ui.previews.AllScreenPreview
import com.sajid.hilt.app.ui.theme.AppDrawerExampleTheme

@Composable
fun AboutScreen(drawerState: DrawerState) {
    // Create a Scaffold with an AppBar
    Scaffold(
        topBar = { AppBar(drawerState = drawerState) }
    ) {
        // Create a Column layout for content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it), // Fill the available space and add padding
            verticalArrangement = Arrangement.Center, // Center the content vertically
            horizontalAlignment = Alignment.CenterHorizontally // Center the content horizontally
        ) {
            Text(stringResource(R.string.about)) // Display the text "About"
        }
    }
}

@AllScreenPreview
@Composable
fun AboutScreenPreview() {
    // Create a DrawerState for the drawer's state
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    AppDrawerExampleTheme {
        // Display the AboutScreen with the provided drawerState
        AboutScreen(drawerState)
    }
}
