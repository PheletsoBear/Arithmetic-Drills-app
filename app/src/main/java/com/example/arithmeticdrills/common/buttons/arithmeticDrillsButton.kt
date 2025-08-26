package com.example.arithmeticdrills.common.buttons

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.example.arithmeticdrills.R
import com.example.arithmeticdrills.ui.theme.ArithmeticDrillsTheme
import com.example.arithmeticdrills.util.Dimens


@Composable
fun NextButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    icon: ImageVector? = null,
    contentDescription: String? = null,
){

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = Color.White,
        ),
        shape = RoundedCornerShape(size = Dimens.small),
        modifier = modifier
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = contentDescription,
                    modifier = Modifier
                        .size(Dimens.large)
                        .padding(end = Dimens.xSmall)
                )
                Spacer(modifier = Modifier.height(Dimens.medium))
            }
            Text(
                text = text,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
            )
        }

    }
}

@Composable
fun BackTextButton(
    text: String,
    onClick:() -> Unit,
    underline: Boolean = false){
    TextButton(
        onClick = onClick
    ){
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.SemiBold,
                textDecoration = if (underline) TextDecoration.Underline else null
            ) ,
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
@Preview(showBackground = true)
@Preview(showBackground = false, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun BackTextButtonPreview() {
    ArithmeticDrillsTheme{
        BackTextButton(
            text = "Back",
            onClick = {}
        )
    }
}

