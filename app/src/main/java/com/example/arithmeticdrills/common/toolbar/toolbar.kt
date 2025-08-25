package com.example.arithmeticdrills.common.toolbar

import android.content.res.Configuration
import androidx.compose.ui.res.painterResource


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.arithmeticdrills.R
import com.example.arithmeticdrills.ui.theme.ArithmeticDrillsTheme
import com.example.arithmeticdrills.ui.theme.ToolbarBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyToolbar(
    title: String,
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    onLanguageClick: () -> Unit,
    showBackButton: Boolean = true,
) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            if (showBackButton) {
            IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(R.string.back_content_description)
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = onShareClick) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Share"
                )
            }
            IconButton(onClick = onLanguageClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_language),
                    contentDescription = "Language"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = ToolbarBackground,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        )
    )
}

@Preview (showBackground = true)
@Preview (showBackground = false, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun MyToolbarPreview(){
    ArithmeticDrillsTheme {
        MyToolbar(
            title = "Arithmetic Drills",
            onBackClick = {},
            onShareClick = {},
            onLanguageClick = {}
        )
    }
}