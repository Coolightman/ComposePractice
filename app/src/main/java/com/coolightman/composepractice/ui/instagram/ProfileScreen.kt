package com.coolightman.composepractice.ui.instagram

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coolightman.composepractice.R
import com.coolightman.composepractice.util.getEmojiByUnicode

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val scaffoldState = rememberScaffoldState()

    val tabViewBarInTop = remember {
        mutableStateOf(false)
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(name = "lexey_drugak")
        },
        bottomBar = {
            BottomBar()
        },
        content = { innerPadding ->
            val scrollState = rememberScrollState()
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .verticalScroll(scrollState)
            ) {

                Spacer(modifier = Modifier.height(4.dp))
                ProfileSection()
                Spacer(modifier = Modifier.height(4.dp))
                val description = "Almost Android programmer ${getEmojiByUnicode(0x1F60F)}\n" +
                        "Try Jetpack Compose! You won't be disappointed ${getEmojiByUnicode(0x1F601)}"
                ProfileDescription(
                    displayName = "Alexey Drugak",
                    description = description,
                    url = "github.com/coolightman",
                    followedBy = listOf("vasya_pupkin", "elon_musk"),
                    otherCount = 3
                )
                Spacer(modifier = Modifier.height(12.dp))
                ButtonSection()
                Spacer(modifier = Modifier.height(20.dp))
                val list = listOf(
                    ImageWithText(
                        image = painterResource(id = R.drawable.hyena),
                        text = "Hyena Story will begin"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.rabbit),
                        text = "Rabbit"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.kermit),
                        text = "Kermit",
                        storiesStatus = StoriesStatus.Active()
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.hyena),
                        text = "Hyena again",
                        storiesStatus = StoriesStatus.Active()
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.kermit),
                        text = "Kermit again"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.rabbit),
                        text = "One more"
                    )
                )
                HighlightSection(highlights = list)
                Spacer(modifier = Modifier.height(12.dp))
                val tabViewBarHeight = 48.dp
                val pxYCoordinate = LocalDensity.current.run { tabViewBarHeight.toPx() }
                PostTabView(
                    modifier = Modifier
                        .height(tabViewBarHeight)
                        .onGloballyPositioned { coordinates ->
                            val position = coordinates.positionInRoot()
                            if (position.y == pxYCoordinate) {
                                tabViewBarInTop.value = true
                                Log.d("ProfileScreen", "TabViewScroll:enable")
                            } else  {
                                tabViewBarInTop.value = false
                                Log.d("ProfileScreen", "TabViewScroll:disable")
                            }
                        },
                    imageWithTexts = listOf(
                        ImageWithText(
                            image = painterResource(id = R.drawable.ic_grid),
                            text = "Posts"
                        ),
                        ImageWithText(
                            image = painterResource(id = R.drawable.reels),
                            text = "Reels"
                        ),
                        ImageWithText(
                            image = painterResource(id = R.drawable.mention),
                            text = "One more"
                        )
                    )
                ) {
                    selectedTabIndex = it
                }
                val topBarHeight = 48.dp
                val bottomBarHeight = innerPadding.calculateBottomPadding()
                val appHeight = LocalConfiguration.current.screenHeightDp.dp
                val tabHeight = appHeight - topBarHeight - bottomBarHeight - tabViewBarHeight
                when (selectedTabIndex) {
                    0 -> PostTabSection(
                        modifier = Modifier
                            .height(tabHeight)
                            .fillMaxWidth(),
                        posts = listOf(
                            painterResource(id = R.drawable.hyena),
                            painterResource(id = R.drawable.kermit),
                            painterResource(id = R.drawable.rabbit),
                            painterResource(id = R.drawable.rabbit),
                            painterResource(id = R.drawable.hyena),
                            painterResource(id = R.drawable.kermit),
                            painterResource(id = R.drawable.hyena),
                            painterResource(id = R.drawable.kermit),
                            painterResource(id = R.drawable.rabbit),
                            painterResource(id = R.drawable.kermit),
                            painterResource(id = R.drawable.hyena),
                            painterResource(id = R.drawable.kermit),
                            painterResource(id = R.drawable.rabbit),
                            painterResource(id = R.drawable.rabbit),
                            painterResource(id = R.drawable.hyena),
                            painterResource(id = R.drawable.kermit),
                            painterResource(id = R.drawable.hyena),
                            painterResource(id = R.drawable.kermit),
                            painterResource(id = R.drawable.rabbit),
                            painterResource(id = R.drawable.kermit),
                        )
                    ) {
//                        enable scroll in LazyGridColumn when tabViewBar in top and disable else
                        tabViewBarInTop.value
                    }
                    1 -> Box(
                        modifier = Modifier
                            .height(tabHeight)
                            .fillMaxWidth()
                    ) {

                    }
                    2 -> Box(
                        modifier = Modifier
                            .height(tabHeight)
                            .fillMaxWidth()
                    ) {

                    }
                }

            }
        }
    )


}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun PreviewOf() {
    ProfileScreen()
}















