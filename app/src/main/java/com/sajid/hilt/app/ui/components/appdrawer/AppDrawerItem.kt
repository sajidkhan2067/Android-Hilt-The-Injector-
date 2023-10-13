package com.sajid.hilt.app.ui.components.appdrawer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.sajid.hilt.DrawerParams
import com.sajid.hilt.MainNavOption
import com.sajid.hilt.app.ui.components.hiltexample.AppDrawerItemInfo
import com.sajid.hilt.app.ui.theme.AppDrawerExampleTheme

@Composable
fun <T> AppDrawerItem(item: AppDrawerItemInfo<T>, onClick: (options: T) -> Unit) =
    Surface(
        color = MaterialTheme.colorScheme.onPrimary,  // Background color
        modifier = Modifier.width(200.dp).padding(16.dp),  // Width and padding
        onClick = { onClick(item.drawerOption) },  // Handle click event
        shape = RoundedCornerShape(50),  // Rounded corners
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,  // Horizontal alignment
            verticalAlignment = Alignment.CenterVertically,  // Vertical alignment
            modifier = Modifier
                .padding(8.dp)  // Padding
        ) {
            Icon(
                painter = painterResource(id = item.drawableId),  // Icon
                contentDescription = stringResource(id = item.descriptionId),  // Icon description
                modifier = Modifier
                    .size(24.dp)  // Icon size
            )
            Spacer(modifier = Modifier.width(16.dp))  // Spacing
            Text(
                text = stringResource(id = item.title),  // Text content
                style = MaterialTheme.typography.bodyMedium,  // Text style
                textAlign = TextAlign.Center,  // Text alignment
            )
        }
    }

// A class to provide preview parameters for AppDrawerItem
class MainStateProvider : PreviewParameterProvider<AppDrawerItemInfo<MainNavOption>> {
    override val values = sequence {
        DrawerParams.drawerButtons.forEach { element ->
            yield(element)
        }
    }
}

@Preview
@Composable
fun AppDrawerItemPreview(@PreviewParameter(MainStateProvider::class) state: AppDrawerItemInfo<MainNavOption>) {
    AppDrawerExampleTheme {
        AppDrawerItem(item = state, onClick = {})
    }
}
