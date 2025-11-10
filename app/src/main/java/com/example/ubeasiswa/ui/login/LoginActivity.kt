package com.example.ubeasiswa.ui.login

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginActivityScreen(navController: NavController) {
    val context = LocalContext.current
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Login", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(20.dp))
        TextField(value = username, onValueChange = { username = it }, label = { Text("Username") })
        Spacer(Modifier.height(10.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(Modifier.height(20.dp))
        Button(
            onClick = {
                if(username=="admin" && password=="admin") {
                    navController.navigate("home") { popUpTo("login") { inclusive = true } }
                } else {
                    Toast.makeText(context, "Username atau password salah", Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) { Text("Login", color = MaterialTheme.colorScheme.background) }

        Spacer(Modifier.height(10.dp))
        TextButton(onClick = { navController.navigate("register") }) { Text("Register") }
    }
}
