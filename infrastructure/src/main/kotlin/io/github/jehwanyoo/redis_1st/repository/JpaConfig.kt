package io.github.jehwanyoo.redis_1st.repository

import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import java.util.logging.Logger

@Configuration
@EnableJpaAuditing
class JpaConfig {

    init {
        println("JpaConfig init")
    }

    @PostConstruct
    fun postConstruct() {
        println("JpaConfig postConstruct")
    }

    private val log: Logger = Logger.getLogger(this.toString())

    @PostConstruct
    fun logCheck() {
        log.info("JpaConfig logCheck")
    }
}
