package br.com.zup.vinteedois

import br.com.zup.vinteedois.itemdenota.ItemDeNotaResponse

class NotaFiscalResponse(notaFiscal: NotaFiscal?) {
        val numero = notaFiscal?.numero
        val serie = notaFiscal?.serie
        val data = notaFiscal?.data
        val itens = notaFiscal?.itens?.map { item ->
            ItemDeNotaResponse(item)
        }
}