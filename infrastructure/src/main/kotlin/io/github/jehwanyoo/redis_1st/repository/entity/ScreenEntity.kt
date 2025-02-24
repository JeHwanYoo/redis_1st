package io.github.jehwanyoo.redis_1st.repository.entity

import io.github.jehwanyoo.redis_1st.model.Screen
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import java.util.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "screen")
class ScreenEntity(
    @Id
    @GeneratedValue
    val id: UUID? = null,       // 고유 ID

    @Column(nullable = false)
    val name: String,           // 상영관 이름

    @Column(name = "seat_row", nullable = false)
    val row: Int,               // 좌석 행 수

    @Column(name = "seat_column", nullable = false)
    val column: Int,            // 좌석 열 수

    @OneToMany(mappedBy = "screen", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val showTimes: List<ShowTimeEntity> = emptyList(),

    @CreatedDate
    @Column(updatable = false)
    val createdAt: LocalDateTime,

    @LastModifiedDate
    val updatedAt: LocalDateTime,
) {
    fun toDomain(): Screen {
        if (id == null) {
            throw IllegalStateException("Entity is not persisted yet: $this")
        }

        return Screen(
            id = id,
            name = name,
            row = row,
            column = column,
            showTimes = showTimes.map { it.toDomain() },
            createdAt = createdAt,
            updatedAt = updatedAt,
        )
    }
}