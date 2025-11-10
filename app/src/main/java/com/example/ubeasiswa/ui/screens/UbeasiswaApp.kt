package com.example.ubeasiswa.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ubeasiswa.ui.login.LoginActivityScreen
import com.example.ubeasiswa.ui.register.RegisterActivityScreen
import com.example.ubeasiswa.ui.home.HomeScreen

@Composable
fun UbeasiswaApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginActivityScreen(navController) }
        composable("register") { RegisterActivityScreen(navController) }
        composable("home") { HomeScreen() }
    }
}
