package com.example.foodapp.pages.homepage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodapp.pages.homepage.widgets.ItemCircle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    navController: NavController
) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(text = "Restaurant", color = MaterialTheme.colorScheme.onPrimary)
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            },
            actions = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.Default.ExitToApp,
                        contentDescription = "Logout",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        )
    }) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(modifier = Modifier.padding(vertical = 10.dp)) {
                LazyRow{
                    items(count = 6) {index ->
                        Spacer(modifier = Modifier.width(14.dp))
                        ItemCircle(index)
                    }
                }
                Spacer(modifier = Modifier.height(25.dp))
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp)
                ){

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainPage() {
//    MainPage()
}