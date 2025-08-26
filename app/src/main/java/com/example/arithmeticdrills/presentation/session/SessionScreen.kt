package com.example.arithmeticdrills.presentation.session

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.arithmeticdrills.ui.theme.ArithmeticDrillsTheme

@Composable
fun SessionScreen(
    navController: NavController
){
    Column(modifier = Modifier.fillMaxSize()) {

    }
}

@Preview (showBackground = true)
@Preview(showBackground = false, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun SessionScreenPreview(){
    val navController = rememberNavController()
    ArithmeticDrillsTheme {
        SessionScreen(navController)
    }
}