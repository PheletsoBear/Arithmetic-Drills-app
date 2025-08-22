package com.example.arithmeticdrills.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.loc.newsapp.presentation.navigation.Route

@Composable
fun HomeScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {
            navController.navigate(Route.HomeScreen.route)
        }) {
            Text("Continue to Home")
        }
    }
}
//@Preview (showBackground = true)
//@Preview (showBackground = false, uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Composable
//private fun HomeScreenPreview(){
//    ArithmeticDrillsTheme {
//        HomeScreen()
//    }
//}
