package com.example.ubeasiswa.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ubeasiswa.R
import com.example.ubeasiswa.ui.theme.Blue
import com.example.ubeasiswa.ui.theme.Orange

@Composable
fun WelcomeScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Kotak gradasi 2/3 layar dengan hanya kiri bawah rounded
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .background(
                    brush = Brush.verticalGradient(listOf(Blue, Orange)),
                    shape = RoundedCornerShape(bottomStart = 100.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(80.dp))
                Text(
                    buildAnnotatedString {
                        append("Discover the ")
                        pushStyle(SpanStyle(fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic))
                        append("path")
                        pop()
                        append(" to your dream scholarship!")
                    },
                    fontSize = 28.sp,
                    lineHeight = 34.sp,
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Image(
                    painter = painterResource(id = R.drawable.maskot),
                    contentDescription = "Maskot",
                    modifier = Modifier.fillMaxWidth(0.9f)
                )
            }
        }

        // Sisanya: teks "UBeasiswa", tombol, version text dengan padding 24dp
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(24.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "UB",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Blue
                )
                Text(
                    "easiswa",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Orange
                )
            }

            Spacer(modifier = Modifier.height(22.dp))

            // Login button (solid, shadow)
            Surface(
                tonalElevation = 6.dp,
                shadowElevation = 6.dp,
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
            ) {
                Button(
                    onClick = { navController.navigate("login") },
                    modifier = Modifier.fillMaxSize(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Blue,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        "Login",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Register button (outline, shadow)
            Surface(
                tonalElevation = 6.dp,
                shadowElevation = 6.dp,
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
            ) {
                OutlinedButton(
                    onClick = { navController.navigate("register") },
                    modifier = Modifier.fillMaxSize(),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Blue),
                    border = ButtonDefaults.outlinedButtonBorder.copy(
                        brush = SolidColor(Blue),
                        width = 2.dp
                    )
                ) {
                    Text(
                        "Register",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Spacer(modifier = Modifier.height(22.dp))

            Text(
                "v1.0.0 (Alpha)",
                color = Orange,
                fontSize = 13.sp
            )
        }
    }
}

@Composable
fun WelcomeActivityScreen(navController: NavController) {
    WelcomeScreen(navController)
}
