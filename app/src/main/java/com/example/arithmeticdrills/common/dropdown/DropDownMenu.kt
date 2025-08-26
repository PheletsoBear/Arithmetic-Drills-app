package com.example.arithmeticdrills.common.dropdown

import android.content.res.Configuration
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.arithmeticdrills.R
import com.example.arithmeticdrills.ui.theme.ArithmeticDrillsTheme
import com.loc.newsapp.util.Constants.AFRIKAANS
import com.loc.newsapp.util.Constants.ENGLISH
import com.loc.newsapp.util.Constants.SELECT
import com.loc.newsapp.util.Constants.SEPEDI
import com.loc.newsapp.util.Constants.ZULU

@Composable
fun LanguageSelector(
    currentLanguage: String,
    icon: Painter?,
    onLanguageSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {
        if (icon != null) {
            Icon(
                painter = icon,
                contentDescription = SELECT
            )
        }
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        val languages = listOf(ENGLISH, SEPEDI, ZULU, AFRIKAANS)

        languages.forEach { language ->
            DropdownMenuItem(
                text = {
                    Text(
                        text = language,
                        fontWeight = if (language == currentLanguage) FontWeight.Bold else FontWeight.Normal,
                        color = if (language == currentLanguage) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                    )
                },
                onClick = {
                    onLanguageSelected(language)
                    expanded = false
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Preview (showBackground = false, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun LanguageSelectorPreview(){
    ArithmeticDrillsTheme {
        LanguageSelector(
            currentLanguage = "Sepedi",
            onLanguageSelected = {},
            icon = painterResource(id =  R.drawable.ic_language)
        )
    }
}
