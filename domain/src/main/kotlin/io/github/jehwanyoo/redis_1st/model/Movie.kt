package io.github.jehwanyoo.redis_1st.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

data class Movie(
    val id: UUID,                   // 고유 ID
    val title: String,              // 영화 제목
    val releaseDate: LocalDate,     // 개봉일
    val thumbnailUrl: String,       // 썸네일 URL
    val runtimeMinutes: Int,        // 러닝 타임 (분)
    val genre: String,              // 장르
    val rating: String,             // 영상물 등급
    val screens: List<Screen>,      // 상영관 리스트
    val createdAt: LocalDateTime,   // 생성 시간
    val updatedAt: LocalDateTime,   // 업데이트 시간
)
