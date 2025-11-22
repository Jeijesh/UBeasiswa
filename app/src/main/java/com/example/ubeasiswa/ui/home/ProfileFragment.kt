package com.example.ubeasiswa.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ubeasiswa.ui.theme.Blue
import com.example.ubeasiswa.ui.theme.Orange

@Composable
fun ProfileFragment(
    navController: NavController? = null,
    modifier: Modifier = Modifier,
    name: String = "Jeijesh",
    email: String = "jeijesh@example.com",
) {
    Column(
        modifier
            .fillMaxSize()
            .background(Color(0xFFF9FAFB))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Foto profil
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(Color(0xFF3F51B5)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = name.first().uppercase(),
                color = Color.White,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Nama dan email
        Text(
            text = name,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = email,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tombol Edit Profil
        Surface(
            tonalElevation = 6.dp,
            shadowElevation = 6.dp,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
        ) {
            Button(
                onClick = { /* dummy */ },
                colors = ButtonDefaults.buttonColors(containerColor = Blue),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    "Edit Profil",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Statistik horizontal dummy
        val stats = listOf(
            "Applied" to 12,
            "Accepted" to 3,
            "Rejected" to 4,
            "Interviews" to 5,
            "Pending" to 2,
            "Offers" to 1,
            "Scholarships" to 6
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(stats) { stat ->
                StatCard(stat.first, stat.second)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Grafik bar dummy
        Text(
            "Beasiswa per Bulan",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        val monthlyData = listOf(3, 5, 2, 4, 1, 3, 5)
        val monthLabels = listOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul")
        val maxValue = (monthlyData.maxOrNull() ?: 1).toFloat()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            monthlyData.forEachIndexed { index, value ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    // Bar
                    Box(
                        modifier = Modifier
                            .width(24.dp)
                            .height(100.dp)
                            .background(Color.LightGray, shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp))
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(value / maxValue)
                                .align(Alignment.BottomCenter)
                                .background(Orange, shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp))
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    // Label
                    Text(
                        text = monthLabels[index],
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Tombol Keluar
        Surface(
            tonalElevation = 6.dp,
            shadowElevation = 6.dp,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
        ) {
            Button(
                onClick = { navController?.navigate("welcome") { popUpTo("home") { inclusive = true } } },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    "Keluar",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun StatCard(title: String, value: Int) {
    Surface(
        color = Color.White,
        tonalElevation = 6.dp,
        shadowElevation = 6.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .width(100.dp)
            .height(80.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = value.toString(),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
    }
}
