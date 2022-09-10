package com.coolightman.composepractice.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coolightman.composepractice.R
import com.coolightman.composepractice.ui.theme.ComposePracticeTheme
import com.coolightman.composepractice.ui.theme.Typography


@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Box(modifier = Modifier.padding(12.dp)) {
        Card(
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp,
            modifier = modifier
                .fillMaxWidth(0.5f)
                .height(200.dp)
        ) {
            Box {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop
                )

//            Gradient
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.4f)
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black)
                            )
                        )
                        .align(Alignment.BottomCenter)
                )

                Text(
                    text = title,
                    style = Typography.body1,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(10.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun ImageCardPrev() {
    ComposePracticeTheme {
        Box(
            Modifier
                .padding(12.dp)
                .fillMaxWidth()

        ) {
            val painter = painterResource(id = R.drawable.kermit)
            val description = "Kermit image"
            val title = "Kermit is touching his head by both of hands"
            ImageCard(
                painter = painter,
                contentDescription = description,
                title = title
            )
        }
    }
}