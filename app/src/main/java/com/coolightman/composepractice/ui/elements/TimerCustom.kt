package com.coolightman.composepractice.ui.elements

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

private const val TIMER_SWEEP_ANGLE = 250f
private const val BOTTOM_SEGMENT = (TIMER_SWEEP_ANGLE - 180) / 2
private const val TIMER_START_ANGLE = -180f - BOTTOM_SEGMENT
private const val FRACTION_ONE = 1f
private const val POINT_BIAS = TIMER_SWEEP_ANGLE - BOTTOM_SEGMENT

@Composable
fun TimerCustom(
    modifier: Modifier = Modifier,
    totalTime: Long,
    handleColor: Color,
    inactiveBarColor: Color = Color.Gray,
    activeBarColor: Color,
    initialValue: Float = 1f,
    strokeWidth: Dp = 6.dp
) {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    var fractionOfArcLength by remember {
        mutableStateOf(initialValue)
    }
    var currentTime by remember {
        mutableStateOf(totalTime)
    }
    var isTimeRunning by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = currentTime, key2 = isTimeRunning) {
        if (currentTime > 0 && isTimeRunning) {
            delay(100L)
            currentTime -= 100L
            fractionOfArcLength = currentTime / totalTime.toFloat()
        } else if (currentTime == 0L) {
            isTimeRunning = false
        }
    }

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.onSizeChanged {
            size = it
        }) {
        Canvas(modifier = modifier) {
            drawArc(
                color = inactiveBarColor,
                startAngle = TIMER_START_ANGLE,
                sweepAngle = TIMER_SWEEP_ANGLE,
                useCenter = false,
                size = Size(size.width.toFloat(), size.height.toFloat()),
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
            drawArc(
                color = activeBarColor,
                startAngle = TIMER_START_ANGLE,
                sweepAngle = TIMER_SWEEP_ANGLE * fractionOfArcLength,
                useCenter = false,
                size = Size(size.width.toFloat(), size.height.toFloat()),
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
            val center = Offset(size.width / 2f, size.height / 2f)
            val beta = (TIMER_SWEEP_ANGLE * fractionOfArcLength - POINT_BIAS)
            val betaRadian = beta * (PI / 180f).toFloat()
            val radius = size.width / 2f
            val a = cos(betaRadian) * radius
            val b = sin(betaRadian) * radius
            drawPoints(
                listOf(Offset(center.x + a, center.y + b)),
                pointMode = PointMode.Points,
                color = if (currentTime == 0L) inactiveBarColor
                else handleColor,
                strokeWidth = (strokeWidth * 3f).toPx(),
                cap = StrokeCap.Round
            )
        }
        Text(
            text = (currentTime / 1000L).toString(),
            fontSize = 44.sp,
            fontWeight = FontWeight.Bold
        )
        Button(
            onClick = {
                if (currentTime == 0L) {
                    currentTime = totalTime
                    fractionOfArcLength = FRACTION_ONE
                } else {
                    isTimeRunning = !isTimeRunning
                }
            },
            modifier = Modifier.align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (!isTimeRunning && currentTime > 0L) Color.Green
                else if (!isTimeRunning && currentTime == 0L) Color.Cyan
                else Color.Red
            )
        ) {
            Text(
                text = if (isTimeRunning && currentTime > 0L) "Pause"
                else if (!isTimeRunning && currentTime == totalTime) "Start"
                else if (!isTimeRunning && currentTime > 0L) "Resume"
                else "Reset"
            )
        }
    }
}

@Preview
@Composable
private fun PreviewOf() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        TimerCustom(
            totalTime = 5 * 1000L,
            handleColor = Color.Green,
            activeBarColor = Color.Green,
            modifier = Modifier.size(150.dp)
        )
    }
}