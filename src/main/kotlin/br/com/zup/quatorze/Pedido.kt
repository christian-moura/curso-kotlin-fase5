package br.com.zup.quatorze

import java.math.BigDecimal

class Pedido(
    val cliente: Cliente,
    val total: BigDecimal,
    val itens: List<ItemDePedido>
) {
}