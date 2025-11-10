package com.example.ubeasiswa.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen() {
    var selectedIndex by remember { mutableStateOf(0) }

    val items = listOf("Home", "Saved", "Applications", "Profile")
    val icons = listOf(
        Icons.Default.Home,
        Icons.Default.Favorite,
        Icons.Default.List,
        Icons.Default.Person
    )

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.primary) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(icons[index], contentDescription = item) },
                        label = { Text(item) },
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.secondary,
                            selectedTextColor = MaterialTheme.colorScheme.secondary
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        when (selectedIndex) {
            0 -> HomeFragment(modifier = Modifier.padding(innerPadding))
            1 -> SavedFragment(modifier = Modifier.padding(innerPadding))
            2 -> ApplicationsFragment(modifier = Modifier.padding(innerPadding))
            3 -> ProfileFragment(modifier = Modifier.padding(innerPadding))
        }
    }
}
