package com.coolightman.composepractice.ui.instagram

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.coolightman.composepractice.R


@Composable
fun ProfileSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(0.9f)
    ) {
        RoundImage(
            image = painterResource(id = R.drawable.my_avatar),
            modifier.size(90.dp),
            storiesStatus = StoriesStatus.None()
        )
        Spacer(modifier = Modifier.fillMaxWidth(0.08f))
        StatSection()
    }
}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {
        ProfileStat(numberText = "33", description = "Posts")
        ProfileStat(numberText = "65", description = "Followers")
        ProfileStat(numberText = "72", description = "Following")
    }
}
