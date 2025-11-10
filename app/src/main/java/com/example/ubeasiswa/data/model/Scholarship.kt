package com.example.ubeasiswa.data.model

data class Scholarship(
    val id: String,
    val title: String,
    val description: String,
    val location: String,
    val deadline: String,
    val bookmarked: Boolean = false,
    val applied: Boolean = false
)
