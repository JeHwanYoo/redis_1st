package io.github.jehwanyoo.redis_1st.repository

import io.github.jehwanyoo.redis_1st.entity.DbMovie
import io.github.jehwanyoo.redis_1st.entity.Movie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class MovieRepositoryImpl(
    private val jpaMovieRepository: JpaMovieRepository
) : MovieRepository {
    override fun findAll(): List<Movie> {
        val dbEntities = jpaMovieRepository.findAll()
        return dbEntities.map { dbEntity -> dbEntity.toDomain() }
    }
}

interface JpaMovieRepository : JpaRepository<DbMovie, UUID>
