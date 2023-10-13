package com.sajid.hilt.app.ui.components.hiltexample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sajid.hilt.app.ui.components.appdrawer.AppDrawerItem
import kotlinx.coroutines.launch
@Composable
fun <T : Enum<T>> AppDrawerContent(
    drawerState: DrawerState,                // Drawer state for managing open/close
    menuItems: List<AppDrawerItemInfo<T>>,  // List of menu items
    defaultPick: T,                        // Default selected menu item
    onClick: (T) -> Unit                   // Callback function for item selection
) {
    var currentPick by remember { mutableStateOf(defaultPick) }  // Track the currently selected item
    val coroutineScope = rememberCoroutineScope()               // Coroutine scope for handling UI events

    ModalDrawerSheet {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(menuItems) { item ->
                        AppDrawerItem(item = item) { navOption ->  // Display each menu item

                            if (currentPick == navOption) {  // If already selected, close the drawer
                                coroutineScope.launch {
                                    drawerState.close()
                                }
                                return@AppDrawerItem
                            }

                            currentPick = navOption  // Set the current selection
                            coroutineScope.launch {
                                drawerState.close()  // Close the drawer
                            }
                            onClick(navOption)       // Trigger the provided callback on item selection
                        }
                    }
                }
            }
        }
    }
}
