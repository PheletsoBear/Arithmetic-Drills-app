package com.example.arithmeticdrills.presentation.onBoarding

import androidx.annotation.DrawableRes
import com.example.arithmeticdrills.R
import com.loc.newsapp.util.Constants.OnboardingDesc1
import com.loc.newsapp.util.Constants.OnboardingDesc2
import com.loc.newsapp.util.Constants.OnboardingDesc3
import com.loc.newsapp.util.Constants.OnboardingDesc4
import com.loc.newsapp.util.Constants.OnboardingTitle1
import com.loc.newsapp.util.Constants.OnboardingTitle2
import com.loc.newsapp.util.Constants.OnboardingTitle3
import com.loc.newsapp.util.Constants.OnboardingTitle4

data class Page (
     val title: String,
     val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = OnboardingTitle1,
        description = OnboardingDesc1,
        image = R.drawable.onboarding1
    ),
    Page(
        title = OnboardingTitle2,
        description =OnboardingDesc2,
        image = R.drawable.onboarding2),
    Page(
        title = OnboardingTitle3,
        description = OnboardingDesc3,
        image = R.drawable.onboarding3),
    Page(
        title = OnboardingTitle4,
        description = OnboardingDesc4,
        image = R.drawable.onboarding4)
)