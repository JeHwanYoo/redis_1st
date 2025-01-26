package io.github.jehwanyoo.redis_1st.v1.tickets

import io.github.jehwanyoo.redis_1st.usecase.port.ReserveTicketUseCase
import io.github.jehwanyoo.redis_1st.v1.BaseApiV1Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TicketController(
    private val reservedTicketUseCase: ReserveTicketUseCase,
) : BaseApiV1Controller() {

    @PostMapping("/tickets")
    fun reserveTicket(@RequestBody request: TicketReserveRequest): TicketReserveResponse {
        val reserved = reservedTicketUseCase.execute(request.toDomain())
        return TicketReserveResponse.fromDomain(reserved)
    }
}
