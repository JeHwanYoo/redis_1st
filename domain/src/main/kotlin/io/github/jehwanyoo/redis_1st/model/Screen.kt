package io.github.jehwanyoo.redis_1st.model

import java.time.LocalDateTime
import java.util.*

data class Screen(
    val id: UUID,                   // 고유 ID
    val name: String,               // 상영관 이름
    val row: Int,                   // 좌석 행 수
    val column: Int,                // 좌석 열 수
    val showTimes: List<ShowTime>,  // 상영 시간 리스트
    val createdAt: LocalDateTime,   // 생성 시간
    val updatedAt: LocalDateTime,   // 업데이트 시간
)
