package com.example.movie.domain.theater.model

import com.example.movie.domain.common.model.BaseModel
import java.time.LocalDateTime

class Theater(
    val id: Long,
    val name: String,
    override val createdBy: String,
    override val createdAt: LocalDateTime,
    override val updatedBy: String,
    override val updatedAt: LocalDateTime
) : BaseModel