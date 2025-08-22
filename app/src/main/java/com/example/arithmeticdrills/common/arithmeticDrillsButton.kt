package com.example.arithmeticdrills.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.arithmeticdrills.R
import com.example.arithmeticdrills.ui.theme.ArithmeticDrillsTheme
import com.example.arithmeticdrills.util.Dimens


@Composable
fun NextButton(
    text: String,
    onClick:() -> Unit
){

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = Color.White,
        ),
        shape = RoundedCornerShape(size = Dimens.small)
    ){
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
        )
    }
}

@Composable
fun BackTextButton(text: String, onClick:() -> Unit){
    TextButton(
        onClick = onClick
    ){
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
            color = colorResource(id = R.color.display_small )
        )
    }
}

@Preview(showBackground = true)
@Preview(showBackground = false, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun NewsButtonPreview() {
    ArithmeticDrillsTheme{
        NextButton(
            text = "Get Started",
            onClick = {}
        )
    }

}

