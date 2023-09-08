package com.example.sb_firstapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sb_firstapp.ui.theme.SB_FirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SB_FirstAppTheme(darkTheme = false) {
                MainPage()
            }
        }
    }
}

@Composable
fun MainPage() {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        LoginForm()
    }
}

@Preview(showBackground = true)
@Composable
fun LoginForm() {
    val username = remember {
        mutableStateOf(TextFieldValue())
    }
    val password = remember {
        mutableStateOf(TextFieldValue())
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.padding(top = 50.dp),
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Medium),
            textDecoration = TextDecoration.Underline,
            text = "Login Form"
        )
        Spacer(modifier = Modifier.height(220.dp))
        TextInputField(
            fieldValue = username.value,
            onFieldValChange = { username.value = it },
            label = "Username"
        )
        Spacer(modifier = Modifier.height(25.dp))
        TextInputField(
            fieldValue = password.value,
            onFieldValChange = { password.value = it },
            label = "Password"
        )
        Spacer(modifier = Modifier.height(35.dp))
        Button(onClick = {
            Log.d("USERNAME", "LoginForm: ${username.value}")
            Log.d("PWD", "LoginForm: ${password.value}")
        }) {
            Text(text = "SUBMIT")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputField(
    label: String,
    fieldValue: TextFieldValue,
    onFieldValChange: (TextFieldValue) -> Unit,
) {
    OutlinedTextField(
        label = { Text(text = label) },
        value = fieldValue,
        onValueChange = onFieldValChange,
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default,
    )
}
