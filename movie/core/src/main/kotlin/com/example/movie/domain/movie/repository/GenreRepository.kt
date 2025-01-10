package com.example.movie.domain.movie.repository

import com.example.movie.domain.movie.model.Genre

interface GenreRepository {
    fun findById(id: Long): Genre?
    fun findAll(): List<Genre>
}