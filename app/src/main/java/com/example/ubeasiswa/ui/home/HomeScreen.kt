package com.example.ubeasiswa.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ubeasiswa.ui.theme.Blue
import com.example.ubeasiswa.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val items = listOf("Home", "Saved", "Applications", "Profile")
    val icons = listOf(
        Icons.Default.Home,
        Icons.Default.Favorite,
        Icons.Default.List,
        Icons.Default.Person
    )

    Scaffold(
        topBar = {
            Surface(
                tonalElevation = 8.dp,
                shadowElevation = 8.dp,
                color = Color.White
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                        .padding(top = 32.dp)
                ) {
                    // Header branding + notification icon
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                "UB",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Blue
                            )
                            Text(
                                "easiswa",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Orange
                            )
                        }

                        // Notification icon with red dot
                        Box {
                            Icon(
                                imageVector = Icons.Default.Notifications, // ganti dengan icon notifikasi nanti
                                contentDescription = "Notification",
                                tint = Color.Gray,
                                modifier = Modifier.size(28.dp)
                            )
                            // Red dot
                            Box(
                                modifier = Modifier
                                    .size(10.dp)
                                    .background(Color.Red, shape = CircleShape)
                                    .align(Alignment.TopEnd)
                                    .offset(x = 4.dp, y = (-4).dp)
                            )
                        }
                    }

                    Spacer(Modifier.height(8.dp))

                    // Subtitle
                    Text(
                        buildAnnotatedString {
                            append("Discover the ")
                            pushStyle(SpanStyle(fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic))
                            append("path")
                            pop()
                            append(" to your dream scholarship!")
                        },
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    )
                }
            }
        },
        bottomBar = {
            Surface(
                tonalElevation = 8.dp,
                shadowElevation = 8.dp,
                color = Color.White
            ) {
                NavigationBar(containerColor = Color.Transparent) {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    icons[index],
                                    contentDescription = item,
                                    tint = if (selectedIndex == index) Orange else Color.Gray
                                )
                            },
                            label = { Text(item, color = if (selectedIndex == index) Orange else Color.Gray) },
                            selected = selectedIndex == index,
                            onClick = { selectedIndex = index }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color(0xFFF9FAFB)) // warna #F9FAFB
        ) {
            when (selectedIndex) {
                0 -> HomeFragment(modifier = Modifier.fillMaxSize())
                1 -> SavedFragment(modifier = Modifier.fillMaxSize())
                2 -> ApplicationsFragment(modifier = Modifier.fillMaxSize())
                3 -> ProfileFragment(
                    navController = navController,  // <== penting
                    modifier = Modifier.fillMaxSize()
                )            }
        }
    }
}
