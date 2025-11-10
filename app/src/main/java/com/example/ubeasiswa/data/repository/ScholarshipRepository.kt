package com.example.ubeasiswa.data.repository

import com.example.ubeasiswa.data.model.Scholarship

class ScholarshipRepository {
    private val scholarships = mutableListOf<Scholarship>()

    fun getAll(): List<Scholarship> = scholarships

    fun add(scholarship: Scholarship) {
        scholarships.add(scholarship)
    }

    fun getBookmarked(): List<Scholarship> = scholarships.filter { it.bookmarked }

    fun getApplied(): List<Scholarship> = scholarships.filter { it.applied }
}
