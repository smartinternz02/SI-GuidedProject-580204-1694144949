package com.example.foodapp.pages.login.widgets

import CustomInputField
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodapp.navigation.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun InputLoginBox(
    navController: NavController,
) {

    var fieldError = remember {
        mutableStateOf(false)
    }
    val username = remember {
        mutableStateOf(TextFieldValue())
    }
    val password = remember {
        mutableStateOf(TextFieldValue())
    }
    Box(
        modifier = Modifier
            .background(color = Color.White, shape = RoundedCornerShape(20.dp))
            .height(280.dp)
            .width(350.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                when {
                    username.value.text.isEmpty() && !fieldError.value -> ""
                    fieldError.value -> "Fields cannot be empty"
                    else -> "Hello ${username.value.text}"
                },
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.Monospace
                )
            )
            Spacer(modifier = Modifier.height(15.dp))
            CustomInputField(
                label = "Username",
                fieldValue = username.value,
                onFieldValChange = { username.value = it }
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomInputField(
                label = "Password",
                fieldValue = password.value,
                onFieldValChange = { password.value = it }
            )
            Spacer(modifier = Modifier.height(25.dp))
            Button(onClick = {
                if (username.value.text.isEmpty() || password.value.text.isEmpty()) {
                    fieldError.value = true
                } else {
                    navController.navigate(Screen.HomeScreen.route)
                }
            }) {
                Text(text = "LOGIN")
            }
        }
    }
}