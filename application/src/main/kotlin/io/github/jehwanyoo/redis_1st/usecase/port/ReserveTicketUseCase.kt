package io.github.jehwanyoo.redis_1st.usecase.port

import io.github.jehwanyoo.redis_1st.model.Ticket
import io.github.jehwanyoo.redis_1st.repository.port.TicketCreateRequest

interface ReserveTicketUseCase {
    fun execute(request: TicketCreateRequest): Ticket
}