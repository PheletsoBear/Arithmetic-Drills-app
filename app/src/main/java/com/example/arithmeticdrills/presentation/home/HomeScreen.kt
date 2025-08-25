package com.example.arithmeticdrills.presentation.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.arithmeticdrills.R
import com.example.arithmeticdrills.common.toolbar.MyToolbar
import com.example.arithmeticdrills.ui.theme.ArithmeticDrillsTheme
import com.loc.newsapp.presentation.navigation.Route

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = { MyToolbar(
            title = stringResource(R.string.app_name),
            onBackClick = {},
            showBackButton = false,
            onShareClick = {},
            onLanguageClick = {}
        ) }
    ) {
        Column(modifier = Modifier.padding(it)) {

        }
    }
}

@Preview (showBackground = true)
@Preview (showBackground = false, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun HomeScreenPreview(){
    val navController = rememberNavController()
    ArithmeticDrillsTheme {
        HomeScreen(navController)
    }
}

