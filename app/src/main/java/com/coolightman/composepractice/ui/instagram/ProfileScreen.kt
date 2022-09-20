package com.coolightman.composepractice.ui.instagram

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coolightman.composepractice.ui.theme.ComposePracticeTheme
import com.coolightman.composepractice.util.getEmojiByUnicode
import com.coolightman.composepractice.util.getHighlightsList
import com.coolightman.composepractice.util.getPostList
import com.coolightman.composepractice.util.getTabViewElements

@Composable
fun ProfileScreen() {

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val scaffoldState = rememberScaffoldState()
    val scrollState = rememberScrollState()
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

                val highlightsList by remember {
                    mutableStateOf(getHighlightsList())
                }

                HighlightSection(highlights = highlightsList)
                Spacer(modifier = Modifier.height(12.dp))

                val tabViewBarHeight = 48.dp
                val pxYCoordinate = LocalDensity.current.run { tabViewBarHeight.toPx() }
                val tabViewElements by remember {
                    mutableStateOf(getTabViewElements())
                }

                PostTabView(
                    modifier = Modifier
                        .height(tabViewBarHeight)
                        .onGloballyPositioned { coordinates ->
                            val position = coordinates.positionInRoot()
                            if (position.y == pxYCoordinate) {
                                tabViewBarInTop.value = true
                                Log.d("ProfileScreen", "TabViewScroll:enable")
                            } else if (tabViewBarInTop.value) {
                                tabViewBarInTop.value = false
                                Log.d("ProfileScreen", "TabViewScroll:disable")
                            }
                        },
                    imageWithTexts = tabViewElements
                ) {
                    selectedTabIndex = it
                }

                val topBarHeight = 48.dp
                val bottomBarHeight = innerPadding.calculateBottomPadding()
                val appHeight = LocalConfiguration.current.screenHeightDp.dp
                val tabHeight = appHeight - topBarHeight - bottomBarHeight - tabViewBarHeight
                val postList by remember {
                    mutableStateOf(getPostList())
                }

                when (selectedTabIndex) {
                    0 -> PostTabSection(
                        modifier = Modifier
                            .height(tabHeight)
                            .fillMaxWidth(),
                        userScrollEnabled = tabViewBarInTop,
                        posts = postList
                    )

                    1 -> Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .height(tabHeight)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Your reels is empty",
                            textAlign = TextAlign.Center
                        )
                    }
                    2 -> Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .height(tabHeight)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Your mentions is empty",
                            textAlign = TextAlign.Center
                        )
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
    ComposePracticeTheme {
        ProfileScreen()
    }
}















