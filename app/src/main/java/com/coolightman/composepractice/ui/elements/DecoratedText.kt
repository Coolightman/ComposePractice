package com.coolightman.composepractice.ui.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coolightman.composepractice.R
import com.coolightman.composepractice.ui.theme.ComposePracticeTheme

@Composable
fun DecoratedText(
    text: String,
    modifier: Modifier = Modifier
) {
    val fontFamily = FontFamily(
        Font(R.font.roboto_thin, FontWeight.Thin),
        Font(R.font.roboto_light, FontWeight.Light),
        Font(R.font.roboto_semibold, FontWeight.SemiBold),
        Font(R.font.roboto_bold, FontWeight.Bold),
        Font(R.font.roboto_medium, FontWeight.Medium)
    )
    Text(
        text = text,
        color = Color.White,
        fontSize = 30.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Light,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline,
        modifier = modifier.fillMaxWidth()
    )
}

@Preview
@Composable
private fun DecoratedTextPreview() {
    ComposePracticeTheme {
        Box(
            Modifier
                .padding(12.dp)
                .fillMaxWidth()

        ) {
            DecoratedText(text = "Gungham style!")
        }
    }
}