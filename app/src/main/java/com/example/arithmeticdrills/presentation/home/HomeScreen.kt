package com.example.arithmeticdrills.presentation.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.arithmeticdrills.R
import com.example.arithmeticdrills.common.buttons.BackTextButton
import com.example.arithmeticdrills.common.buttons.NextButton
import com.example.arithmeticdrills.common.toolbar.MyToolbar
import com.example.arithmeticdrills.ui.theme.ArithmeticDrillsTheme
import com.example.arithmeticdrills.util.Dimens

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
      val verticalScrollState = rememberScrollState()
        Column(
            modifier = Modifier
            .padding(it)
            .fillMaxSize()
            .padding(horizontal = Dimens.small)
            .verticalScroll(verticalScrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
            ) {
            Image(
                painter = painterResource(id = R.drawable.mathdrill),
                contentDescription = "OnBoarding Image",
                modifier = Modifier
                    .padding(top = Dimens.large*2)
                    .fillMaxWidth(),
                contentScale = ContentScale.Inside
            )

            Spacer(modifier = Modifier.height(Dimens.large*3))

                NextButton(
                    text = stringResource(R.string.join_a_friend),
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(Dimens.large*2),
                    icon = ImageVector.vectorResource(id = R.drawable.ic_bluetooth),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.height(Dimens.medium))
                NextButton(
                    text = stringResource(R.string.play),
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(Dimens.large*2),
                    icon = ImageVector.vectorResource(id = R.drawable.ic_play),
                    contentDescription = ""
                )

            Row (
                horizontalArrangement = Arrangement.spacedBy(Dimens.large*5)
            ){
                BackTextButton(
                    text = stringResource(R.string.leader_board),
                    onClick = {},
                    underline = true
                )
                BackTextButton(
                    text = stringResource(R.string.instructions),
                    onClick = {},
                    underline = true
                )
            }
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

