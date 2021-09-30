package br.com.zup.vinteeum

import io.micronaut.data.model.Pageable
import io.micronaut.data.model.Sort
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable

@Controller("/api/transacoes")
class TransacaoController(val transacaoRepository: TransacaoRepository) {

    @Get("/cliente/{id}")
    fun listarTransacaoIdCliente(@PathVariable id :Long) : HttpResponse<Any> {
        val transacoes = transacaoRepository.findAllByClienteId(id, Pageable.from(0, 10, Sort.of(Sort.Order.desc("criadaEm"))))
        return HttpResponse.ok(transacoes)
    }
}