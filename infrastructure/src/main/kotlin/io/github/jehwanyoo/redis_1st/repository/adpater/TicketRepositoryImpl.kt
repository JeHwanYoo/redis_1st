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
import org.apache.commons.lang3.builder.ReflectionToStringBuilder
import org.apache.commons.lang3.builder.ToStringStyle
import org.slf4j.LoggerFactory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class TicketRepositoryImpl(
    @PersistenceContext
    private val entityManager: EntityManager,
    private val jpaTicketRepository: JpaTicketRepository
) : TicketRepository {
    private val log = LoggerFactory.getLogger(javaClass)

    @Transactional
    override fun create(request: TicketCreateRequest): Ticket {
        val movieProxy = entityManager.getReference(MovieEntity::class.java, request.movieId)
        val screenProxy = entityManager.getReference(ScreenEntity::class.java, request.screenId)
        val showTimeProxy = entityManager.getReference(ShowTimeEntity::class.java, request.showTimeId)

        val movieStr = ReflectionToStringBuilder.toString(
            movieProxy,
            ToStringStyle.MULTI_LINE_STYLE
        )
        log.info("Movie Proxy detail: {}", movieStr)

        val entity = jpaTicketRepository.save(
            TicketEntity(
                id = null,
                createdAt = null,
                movie = movieProxy,
                screen = screenProxy,
                showTime = showTimeProxy,
            )
        )

        // 영속성 컨텍스트 flush
        entityManager.flush()
        entityManager.refresh(entity) // DB에서 다시 읽어오기

        val entityStr = ReflectionToStringBuilder.toString(
            entity,
            ToStringStyle.MULTI_LINE_STYLE
        )
        log.info("entity detail: {}", entityStr)

        return entity.toDomain()
    }
}

interface JpaTicketRepository : JpaRepository<TicketEntity, UUID>
