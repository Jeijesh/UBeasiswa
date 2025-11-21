package com.example.ubeasiswa.ui.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ubeasiswa.ui.theme.Blue
import com.example.ubeasiswa.ui.theme.Orange

@Composable
fun LoginActivity(navController: NavController) {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Judul login
        Text(
            "Login",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Orange,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(32.dp))

        // Email
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.5.dp, Blue, RoundedCornerShape(8.dp))
                .background(Color.Transparent, RoundedCornerShape(8.dp))
                .padding(horizontal = 12.dp, vertical = 14.dp)
        ) {
            if (email.isEmpty()) {
                Text("Email", color = Color.Gray)
            }
            BasicTextField(
                value = email,
                onValueChange = { email = it },
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(color = Color.Black),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(Modifier.height(12.dp))

        // Password
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.5.dp, Blue, RoundedCornerShape(8.dp))
                .background(Color.Transparent, RoundedCornerShape(8.dp))
                .padding(horizontal = 12.dp, vertical = 14.dp)
        ) {
            if (password.isEmpty()) {
                Text("Password", color = Color.Gray)
            }
            BasicTextField(
                value = password,
                onValueChange = { password = it },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                textStyle = LocalTextStyle.current.copy(color = Color.Black),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(Modifier.height(12.dp))

        // Lupa password
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                "Lupa password?",
                color = Blue,
                fontSize = 14.sp,
                modifier = Modifier.clickable {
                    Toast.makeText(
                        context,
                        "Fitur lupa password belum tersedia",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )
        }

        Spacer(Modifier.height(24.dp))

        // Button Login
        Surface(
            tonalElevation = 6.dp,
            shadowElevation = 6.dp,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
        ) {
            Button(
                onClick = {
                    if (email == "admin" && password == "admin123") {
                        navController.navigate("home") { popUpTo("login") { inclusive = true } }
                    } else {
                        Toast.makeText(context, "Email atau password salah", Toast.LENGTH_SHORT).show()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Orange),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    "Login",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        // Buat akun
        Text(
            buildAnnotatedString {
                append("Belum punya akun? ")
                pushStyle(SpanStyle(color = Blue, textDecoration = TextDecoration.Underline))
                append("Buat akun")
            },
            fontSize = 14.sp,
            modifier = Modifier.clickable { navController.navigate("register") }
        )

        Spacer(Modifier.height(24.dp))

        Text(
            "atau lanjut dengan:",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(Modifier.height(12.dp))

        // Button SSO biru
        Surface(
            tonalElevation = 6.dp,
            shadowElevation = 6.dp,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
        ) {
            Button(
                onClick = { navController.navigate("home") },
                colors = ButtonDefaults.buttonColors(containerColor = Blue),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    "SSO Universitas Brawijaya",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun LoginActivityScreen(navController: NavController) {
    LoginActivity(navController)
}
