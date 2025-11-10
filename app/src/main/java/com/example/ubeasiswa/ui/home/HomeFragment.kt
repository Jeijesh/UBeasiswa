package com.example.ubeasiswa.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeFragment(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize().padding(20.dp)) {
        Text("Home: Search & Nearby Scholarships")
    }
}
