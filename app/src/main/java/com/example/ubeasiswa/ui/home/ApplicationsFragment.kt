package com.example.ubeasiswa.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ApplicationsFragment(modifier: Modifier = Modifier) {

    // Dummy data aplikasi — nanti kamu bisa sambungkan ke Repository
    val appliedList = listOf(
        ApplicationItem("Beasiswa Unggulan", "Review"),
        ApplicationItem("LPDP Reguler", "Diterima"),
        ApplicationItem("Djarum Beasiswa Plus", "Ditolak"),
        ApplicationItem("KIP Kuliah", "Review"),
    )

    Column(
        modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            "My Applications",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.height(20.dp))

        appliedList.forEach { item ->
            ApplicationCard(item)
            Spacer(Modifier.height(12.dp))
        }
    }
}

// 📌 Model sederhana
data class ApplicationItem(
    val name: String,
    val status: String
)

@Composable
fun ApplicationCard(item: ApplicationItem) {

    // Warna status
    val statusColor = when (item.status.lowercase()) {
        "diterima" -> Color(0xFF4CAF50)  // hijau
        "ditolak" -> Color(0xFFE53935)   // merah
        else -> Color(0xFFFFA726)        // orange (review)
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(item.name, style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(6.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Status Badge
                Box(
                    modifier = Modifier
                        .background(statusColor, RoundedCornerShape(20.dp))
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = item.status,
                        color = Color.White,
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                // Tombol Upload Dokumen (CameraX)
                TextButton(onClick = {
                    // nanti diarahkan ke CameraX screen / Activity
                }) {
                    Text("Upload Dokumen")
                }
            }
        }
    }
}
