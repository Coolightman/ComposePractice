package com.coolightman.composepractice.ui.instagram

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.coolightman.composepractice.R

@Composable
fun BottomBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(MaterialTheme.colors.background)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.home),
            contentDescription = null,
            modifier = Modifier
                .padding(12.dp)
                .size(22.dp)
                .clickable { }
        )
        Icon(
            painter = painterResource(id = R.drawable.search),
            contentDescription = null,
            modifier = Modifier
                .padding(12.dp)
                .size(22.dp)
                .clickable { }
        )
        Icon(
            painter = painterResource(id = R.drawable.plus),
            contentDescription = null,
            modifier = Modifier
                .padding(12.dp)
                .size(22.dp)
                .clickable { }
        )
        Icon(
            painter = painterResource(id = R.drawable.like),
            contentDescription = null,
            modifier = Modifier
                .padding(12.dp)
                .size(26.dp)
                .clickable { }
        )
        Image(
            painter = painterResource(id = R.drawable.hyena),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(12.dp)
                .size(24.dp)
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colors.primaryVariant,
                    shape = CircleShape
                )
                .clip(CircleShape)
                .clickable { }
        )
    }
}