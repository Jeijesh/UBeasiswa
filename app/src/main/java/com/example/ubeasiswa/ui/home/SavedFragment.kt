package com.example.ubeasiswa.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SavedFragment(modifier: Modifier = Modifier) {

    // Search Query untuk filter
    var searchQuery by remember { mutableStateOf("") }

    // Dummy data saved list (nanti ganti dari Repository)
    val savedScholarships = listOf(
        "Beasiswa Unggulan",
        "LPDP",
        "Djarum Beasiswa Plus",
        "Beasiswa Pemprov Jatim",
        "Kampus Merdeka Scholarship"
    )

    // Filtering data berdasarkan searchQuery
    val filteredList = savedScholarships.filter {
        it.contains(searchQuery, ignoreCase = true)
    }

    Column(
        modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            "Saved Scholarships",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(20.dp))

        // 🔍 Search khusus untuk saved list
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Cari beasiswa tersimpan...") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        // 💾 Menampilkan hasil search
        if (filteredList.isEmpty()) {
            Text("Tidak ada beasiswa yang cocok.")
        } else {
            filteredList.forEach { name ->
                Text(
                    text = "• $name",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(vertical = 6.dp)
                )
            }
        }
    }
}
