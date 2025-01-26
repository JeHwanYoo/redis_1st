package io.github.jehwanyoo.redis_1st.repository.port

import io.github.jehwanyoo.redis_1st.model.Ticket
import java.util.*

interface TicketRepository {
    fun create(
        request: TicketCreateRequest,
    ): Ticket
}

data class TicketCreateRequest(
    val movieId: UUID,              // 영화 고유 ID
    val screenId: UUID,             // 스크린 고유 ID
    val showTimeId: UUID,           // 상영 시간 ID
)
