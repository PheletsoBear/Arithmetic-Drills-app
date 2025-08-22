package com.example.arithmeticdrills.presentation.onBoarding

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.arithmeticdrills.MainViewModel
import com.example.arithmeticdrills.common.BackTextButton
import com.example.arithmeticdrills.common.NextButton
import com.example.arithmeticdrills.presentation.onBoarding.components.OnBoardingPage
import com.example.arithmeticdrills.presentation.onBoarding.components.PageIndicator
import com.example.arithmeticdrills.ui.theme.ArithmeticDrillsTheme
import com.example.arithmeticdrills.util.Dimens
import com.loc.newsapp.data.manager.LocalUserManager
import com.loc.newsapp.presentation.navigation.Route
import kotlinx.coroutines.launch

@SuppressLint("RememberReturnType")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavController
) {
    val viewModel: MainViewModel = hiltViewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonState = remember {
            derivedStateOf {
                val isFirstPage = pagerState.currentPage == 0
                val isLastPage = pagerState.currentPage == pages.size - 1

                when {
                    isFirstPage -> listOf("", "Next")
                    isLastPage -> listOf("back", "get Started")
                    else -> listOf("Back", "Next")
                }
            }
        }

        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(
                page = pages[index],
               modifier = Modifier
                   .fillMaxHeight(fraction = 0.6f)
                   .fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.large),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            PageIndicator(
                pageSize = pages.size,
                selectedPage = pagerState.currentPage
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                val scope = rememberCoroutineScope()

                if (buttonState.value[0].isNotEmpty()) {
                    BackTextButton(
                        text = buttonState.value[0],
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                            }
                        }
                    )
                }
                NextButton(
                    text = buttonState.value[1],
                    onClick = {
                        scope.launch {
                            if (pagerState.currentPage == pages.size - 1) {
                                viewModel.saveAppEntry()
                                navController.navigate(Route.HomeScreen.route)
                            } else {
                                pagerState.animateScrollToPage(
                                    page = pagerState.currentPage + 1
                                )
                            }
                        }
                    }
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

