package com.example.arithmeticdrills

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.arithmeticdrills.ui.theme.ArithmeticDrillsTheme
import com.loc.newsapp.data.manager.LocalUserManager
import com.loc.newsapp.presentation.navigation.NavGraph
import com.loc.newsapp.presentation.navigation.Route
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var localUserManager: LocalUserManager

    val viewModel: MainViewModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.splashCondition
            }
        }

        enableEdgeToEdge()
        setContent {
            val hasSeenOnboarding = viewModel.hasSeenOnboarding.collectAsState()

            hasSeenOnboarding.value?.let { seen ->
                ArithmeticDrillsTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) {
                        NavGraph(
                            startDestination = if (seen) {
                                Route.HomeScreen.route
                            } else {
                                Route.OnBoardingScreen.route
                            },
                            localUserManager = localUserManager
                        )
                    }
                }
            }
        }
    }
}
