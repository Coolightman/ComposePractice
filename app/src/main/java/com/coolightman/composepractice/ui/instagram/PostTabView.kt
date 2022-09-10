package com.coolightman.composepractice.ui.instagram

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit,
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color.Gray
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        modifier = modifier
    ) {
        imageWithTexts.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) MaterialTheme.colors.primaryVariant else inactiveColor,
                    modifier = Modifier
                        .padding(12.dp)
                        .size(24.dp)
                )
            }
        }
    }
}