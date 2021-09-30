package br.com.zup.quatorze

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/api/pedidos")
class PedidoController {

    @Post
    fun cadastra(@Body @Valid pedidoRequest: PedidoRequest): HttpResponse<Any> {
        val pedido = pedidoRequest.toPedido()
        return HttpResponse.ok(pedido)
    }
}