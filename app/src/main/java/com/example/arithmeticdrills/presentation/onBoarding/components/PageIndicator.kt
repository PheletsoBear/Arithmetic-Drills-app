package com.example.arithmeticdrills.presentation.onBoarding.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.arithmeticdrills.ui.theme.ArithmeticDrillsTheme
import com.example.arithmeticdrills.ui.theme.BlueGray
import com.example.arithmeticdrills.util.Dimens


@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageSize: Int,
    selectedPage: Int,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = BlueGray
){
    Row(
         horizontalArrangement = Arrangement.spacedBy(Dimens.small)
    ){
        repeat(pageSize){
          page ->
            Box(
                modifier = modifier.size(Dimens.mediumSmall)
                    .clip(CircleShape)
                    .background(color = if (page == selectedPage) selectedColor else unselectedColor)
            )
        }
    }
}

@Preview (showBackground = true)
@Preview (showBackground = false, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private  fun PageIndicatorPreview(){
    ArithmeticDrillsTheme {
        PageIndicator(
            pageSize = 3,
            selectedPage = 1
        )
    }
}

