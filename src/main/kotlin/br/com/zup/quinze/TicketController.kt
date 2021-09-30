package br.com.zup.quinze

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.validation.Valid


@Validated
@Controller("/api/tickets")
class TicketController(val ticketRepository: TicketRepository) {
    @Post
    fun cadastra(@Body @Valid ticketRequest: TicketRequest): HttpResponse<Any> {
        var ticket = ticketRequest.toTicket()
        ticketRepository.save(ticket)
        val uri = UriBuilder.of("/tickets/{id}")
            .expand(mutableMapOf(Pair("id", ticket.id)))
        return HttpResponse.created(uri)
    }
}