package com.example.assignmentthree


import ImageRow
import InputLoginBox
import LoginBox
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignmentthree.ui.theme.AssignmentThreeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentThreeTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                MainScreen()
            }
        }
    }
}

val gradientColors = listOf(
    Color(215, 117, 255, 128),
    Color(255, 188, 117, 230)
)


@Composable
fun MainScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = Brush.linearGradient(colors = gradientColors))
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                LoginBox()
                Spacer(modifier = Modifier.height(60.dp))
                InputLoginBox()
                Spacer(modifier = Modifier.height(40.dp))
                ImageRow(resourceID = R.drawable.amazon_logo, urlString = "https://www.amazon.in/")
                ImageRow(resourceID = R.drawable.flipkart_logo, urlString = "https://www.flipkart.com/")
                ImageRow(resourceID = R.drawable.github_logo, urlString = "https://github.com/")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}