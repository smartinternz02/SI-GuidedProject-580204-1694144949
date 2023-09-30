package com.example.foodapp.pages.deails

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodapp.pages.deails.widgets.ItemCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = { SnackbarHost (hostState = snackbarHostState)},
        topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "Detail Page", color = MaterialTheme.colorScheme.onSecondary) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.secondary
            ),
            navigationIcon = {
                Icon(
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    },
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            },
        )
    }) {
        Surface(
            modifier = Modifier
                .padding(it)
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            LazyColumn(modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp)){
                items(count = 6){index ->
                    ItemCard(scope,snackbarHostState,index)
                    Spacer(modifier = Modifier.height(14.dp))
                }
            }
        }
    }
}

