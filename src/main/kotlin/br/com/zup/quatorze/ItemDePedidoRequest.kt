package br.com.zup.quatorze

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Introspected
data class ItemDePedidoRequest(
    @field:NotBlank val codigo: String,
    @field:NotNull val preco: BigDecimal,
    @field:NotNull val quantidade: Int
) {
    fun toItemDePedido(): ItemDePedido {
        return ItemDePedido(codigo, preco, quantidade)
    }
}