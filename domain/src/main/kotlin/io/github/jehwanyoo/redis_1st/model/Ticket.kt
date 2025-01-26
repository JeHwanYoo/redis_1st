package io.github.jehwanyoo.redis_1st.model

import java.time.LocalDateTime
import java.util.*

data class Ticket(
    val id: UUID,                   // 고유 ID
    val movieId: UUID,              // 영화 고유 ID
    val screenId: UUID,             // 스크린 고유 ID
    val showTimeId: UUID,           // 상영 시간 ID
    val createdAt: LocalDateTime,   // 생성 시간
)
