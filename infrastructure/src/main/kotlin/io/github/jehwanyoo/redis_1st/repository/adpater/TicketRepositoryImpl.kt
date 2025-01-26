package io.github.jehwanyoo.redis_1st.repository.adpater

import io.github.jehwanyoo.redis_1st.model.Ticket
import io.github.jehwanyoo.redis_1st.repository.entity.MovieEntity
import io.github.jehwanyoo.redis_1st.repository.entity.ScreenEntity
import io.github.jehwanyoo.redis_1st.repository.entity.ShowTimeEntity
import io.github.jehwanyoo.redis_1st.repository.entity.TicketEntity
import io.github.jehwanyoo.redis_1st.repository.port.TicketCreateRequest
import io.github.jehwanyoo.redis_1st.repository.port.TicketRepository
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class TicketRepositoryImpl(
    @PersistenceContext
    private val entityManager: EntityManager,
    private val jpaTicketRepository: JpaTicketRepository
) : TicketRepository {

    @Transactional
    override fun create(request: TicketCreateRequest): Ticket {
        val movieProxy = entityManager.getReference(MovieEntity::class.java, request.movieId)
        val screenProxy = entityManager.getReference(ScreenEntity::class.java, request.screenId)
        val showTimeProxy = entityManager.getReference(ShowTimeEntity::class.java, request.showTimeId)

        return jpaTicketRepository.save(
            TicketEntity(
                id = null,
                createdAt = null,
                movie = movieProxy,
                screen = screenProxy,
                showTime = showTimeProxy,
            )
        ).toDomain()
    }
}

interface JpaTicketRepository : JpaRepository<TicketEntity, UUID>
