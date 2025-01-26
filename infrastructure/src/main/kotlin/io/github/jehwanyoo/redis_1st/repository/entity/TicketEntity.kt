package io.github.jehwanyoo.redis_1st.repository.entity

import io.github.jehwanyoo.redis_1st.model.Ticket
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "ticket")
class TicketEntity(
    @Id
    @GeneratedValue
    val id: UUID? = null,           // 고유 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    val movie: MovieEntity,         // 연관된 영화

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id", nullable = false)
    val screen: ScreenEntity,       // 연관된 상영관

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_time_id", nullable = false)
    val showTime: ShowTimeEntity,   // 연관된 시간대

    @CreatedDate
    @Column(updatable = false)
    val createdAt: LocalDateTime,
) {
    fun toDomain(): Ticket {
        if (id == null || movie.id == null || screen.id == null || showTime.id == null) {
            throw IllegalStateException("Entity is not persisted yet: $this")
        }

        return Ticket(
            id = id,
            movieId = movie.id,
            screenId = screen.id,
            showTimeId = showTime.id,
            createdAt = createdAt,
        )
    }
}