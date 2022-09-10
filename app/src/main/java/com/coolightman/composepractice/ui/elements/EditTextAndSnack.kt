package com.coolightman.composepractice.ui.elements

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coolightman.composepractice.R
import kotlinx.coroutines.launch

@Composable
fun EditTextAndSnack() {
    val scaffoldState = rememberScaffoldState()
    var textFieldState by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            OutlinedTextField(
                value = textFieldState,
                label = {
                    Text(text = "Enter your name")
                },
                onValueChange = {
                    textFieldState = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(onClick = {
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        "Hello $textFieldState",
                        duration = SnackbarDuration.Short
                    )
                }
            }) {
                Text("Greet me!")
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_emoji_people_24),
                    contentDescription = "Button image",
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun EditTextAndSnackPreview() {
    EditTextAndSnack()
}