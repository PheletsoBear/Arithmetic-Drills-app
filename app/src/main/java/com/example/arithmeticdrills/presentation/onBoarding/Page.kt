package com.example.arithmeticdrills.presentation.onBoarding

import com.example.arithmeticdrills.R
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Page (
     val title: String,
     val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Ready to drill?",
        description = "Solve 10 questions per session and improve your math skills",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Track Progress",
        description ="View your results after each session and see how you improve",
        image = R.drawable.onboarding2),
    Page(
        title = "Multiplayer mode",
        description = "Share your scores with friends and compete in multiplayer mode",
        image = R.drawable.onboarding3)
)