package com.example.foodapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodapp.pages.homepage.HomePage
import com.example.foodapp.pages.login.Login

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(route = Screen.LoginScreen.route){
            Login(navController)
        }
        composable(route = Screen.HomeScreen.route){
            HomePage(navController)
        }
    }

}

