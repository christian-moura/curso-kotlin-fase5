package br.com.zup.quatorze

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.Valid
import javax.validation.constraints.NotNull

@Introspected
data class PedidoRequest(
    @field:NotNull @Valid val cliente: ClienteRequest,
    @field:NotNull val total: BigDecimal,
    @field:NotNull @Valid val itens: List<ItemDePedidoRequest>
) {
    fun toPedido():Pedido{
        return Pedido(cliente.toCliente(),total, itens.map { itemDePedidoRequest -> itemDePedidoRequest.toItemDePedido()})
    }
}