package com.sajid.hilt.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.sajid.hilt.R
import com.sajid.hilt.app.AppEvent
import com.sajid.hilt.app.ui.components.appbar.AppBar

@Composable
fun HomeScreen(
    drawerState: DrawerState, onEvent: (appEvent: AppEvent) -> Unit
) {
    Scaffold(topBar = { AppBar(drawerState = drawerState) }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { onEvent(AppEvent.SendMail) }) {
                Text(stringResource(R.string.click_to_send_an_email),
                    fontSize = 24.sp)
            }
        }
    }
}