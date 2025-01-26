package io.github.jehwanyoo.redis_1st.v1.tickets

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.jehwanyoo.redis_1st.model.Ticket
import io.github.jehwanyoo.redis_1st.repository.port.TicketCreateRequest
import java.util.*

data class TicketReserveResponse(
    @JsonProperty("id") val id: UUID,                          // 고유 ID
    @JsonProperty("movie_id") val movieId: UUID,               // 영화 고유 식별자
    @JsonProperty("screen_id") val screenId: UUID,             // 스크린 고유 ID
    @JsonProperty("show_time_id") val showTimeId: UUID,        // 상영 시간 ID
) {
    companion object {
        fun fromDomain(ticket: Ticket): TicketReserveResponse {
            return TicketReserveResponse(
                id = ticket.id,
                movieId = ticket.movieId,
                screenId = ticket.screenId,
                showTimeId = ticket.showTimeId,
            )
        }
    }
}

data class TicketReserveRequest(
    @JsonProperty("movie_id") val movieId: UUID,               // 영화 고유 식별자
    @JsonProperty("screen_id") val screenId: UUID,             // 스크린 고유 ID
    @JsonProperty("show_time_id") val showTimeId: UUID,        // 상영 시간 ID
) {
    fun toDomain(): TicketCreateRequest {
        return TicketCreateRequest(
            movieId = movieId,
            screenId = screenId,
            showTimeId = showTimeId,
        )
    }
}