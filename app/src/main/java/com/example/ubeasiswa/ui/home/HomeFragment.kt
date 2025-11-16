package com.example.ubeasiswa.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeFragment(
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedLocation by remember { mutableStateOf("Semua Lokasi") }

    val locationOptions = listOf(
        "Semua Lokasi",
        "Near You (GPS)",
        "Jakarta",
        "Bandung",
        "Surabaya",
        "Yogyakarta"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        // 🔍 Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Cari Beasiswa...") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 📍 Filter Lokasi (Dropdown)
        LocationDropdown(
            selected = selectedLocation,
            options = locationOptions,
            onSelect = { selectedLocation = it }
        )

        Spacer(modifier = Modifier.height(20.dp))

        // TODO: Tampilkan daftar beasiswa yang difilter
        Text(
            text = "Hasil pencarian: \"$searchQuery\"\nLokasi: $selectedLocation",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun LocationDropdown(
    selected: String,
    options: List<String>,
    onSelect: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    OutlinedButton(
        onClick = { expanded = true },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(selected)
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        options.forEach { location ->
            DropdownMenuItem(
                text = { Text(location) },
                onClick = {
                    onSelect(location)
                    expanded = false
                }
            )
        }
    }
}
