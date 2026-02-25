package com.example.gamecompose

import android.R.attr.name
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamecompose.ui.theme.GameComposeTheme
import com.example.gamecompose.ui.theme.oitobit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GameComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainGameScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainGameScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        Row(
            modifier = modifier
                .padding(2.dp, 10.dp, 0.dp, 2.dp)
                .fillMaxWidth()
                .height(30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "SCORE: 0050", fontFamily = oitobit, fontSize = 22.sp, color = Color.White
            )
            Row() {
                Text(
                    text = "LIVES: ", fontFamily = oitobit, fontSize = 25.sp, color = Color.White
                )
                AndroidHp()
                AndroidHp()
                AndroidHp()
            }

        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            AndroidEnemy(
                color = Color.Yellow
            )
            AndroidEnemy(
                color = Color.Red
            )
            AndroidEnemy(
                color = Color.Blue
            )
            AndroidEnemy(
                color = Color.Yellow
            )
            AndroidEnemy(
                color = Color.Yellow
            )
        }
        Column(modifier = Modifier.weight(1F)
            .fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Player(modifier = Modifier.align(Alignment.CenterHorizontally)
                .padding(0.dp, 0.dp, 0.dp, 10.dp))
        }
        Row(modifier = Modifier.background(Color(114, 110, 110, 93))
            .height(50.dp)
            .fillMaxWidth()
            .padding(0.dp, 0.dp, 0.dp, 14.dp)) {
            Text(text = "PRESS TO START",
                fontSize = 20.sp,
                fontFamily = oitobit,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
                    .align(Alignment.CenterVertically)

            )
        }
    }
}

@Composable
fun AndroidHp(modifier: Modifier = Modifier) {
    Image(
        contentDescription = "Android Enemy",
        painter = painterResource(R.drawable.android_24),
        modifier = modifier.size(32.dp),
        colorFilter = ColorFilter.tint(Color.Green)

    )
}

@Composable
fun AndroidEnemy(modifier: Modifier = Modifier, color: Color){
    Image(
        contentDescription = "Android Enemy",
        painter = painterResource(R.drawable.android_24),
        modifier = modifier.size(70.dp),
        colorFilter = ColorFilter.tint(color)
    )
}

@Composable
fun Player(modifier: Modifier = Modifier) {
    Image(
        contentDescription = "Player",
        painter = painterResource(R.drawable.outline_accessible_forward_24),
        modifier = modifier.size(70.dp),
        colorFilter = ColorFilter.tint(Color.White)

    )
}