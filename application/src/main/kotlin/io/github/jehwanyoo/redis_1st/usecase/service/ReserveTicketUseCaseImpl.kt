package io.github.jehwanyoo.redis_1st.usecase.service

import io.github.jehwanyoo.redis_1st.model.Ticket
import io.github.jehwanyoo.redis_1st.repository.port.TicketCreateRequest
import io.github.jehwanyoo.redis_1st.repository.port.TicketRepository
import io.github.jehwanyoo.redis_1st.usecase.port.ReserveTicketUseCase
import org.springframework.stereotype.Service

@Service
class ReserveTicketUseCaseImpl(
    private val ticketRepository: TicketRepository,
) : ReserveTicketUseCase {
    override fun execute(request: TicketCreateRequest): Ticket {
        return ticketRepository.create(request)
    }
}
