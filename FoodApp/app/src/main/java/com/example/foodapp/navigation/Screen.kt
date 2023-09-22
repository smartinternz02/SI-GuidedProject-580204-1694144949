package com.example.foodapp.navigation

sealed class Screen(val route : String ){
    object LoginScreen : Screen("login-screen")
    object HomeScreen : Screen("home-screen")
    object DetailScreen : Screen("detail-screen")
}
