package com.sajid.hilt.app.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sajid.hilt.app.ui.previews.AllPreviews
import com.sajid.hilt.app.ui.theme.AppDrawerExampleTheme
import com.sajid.hilt.R
// Define a typealias for the onClick function, which takes no arguments and returns Unit.
typealias OnClickFunction = () -> Unit

// Composable function for a custom button with a provided text and onClick function.
@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    @StringRes text: Int, // Text resource ID for the button label
    onClick: OnClickFunction // Function to be executed when the button is clicked
) {
    Button(
        modifier = modifier
            .height(60.dp)
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .shadow(4.dp, RoundedCornerShape(20.dp)), // Apply styling to the button
        onClick = onClick // Specify the provided onClick function
    ) {
        Text(
            stringResource(id = text), // Display the text associated with the provided resource ID
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelMedium.copy(
                color = MaterialTheme.colorScheme.onPrimary
            ), // Define the text style
        )
    }
}

// Composable function for previewing the AppButton component.
@AllPreviews
@Composable
fun AppButtonPreview() {
    AppDrawerExampleTheme {
        AppButton(text = R.string.next) {} // Display a preview of the AppButton with the "Next" label
    }
}
