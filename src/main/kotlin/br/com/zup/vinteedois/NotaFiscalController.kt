package br.com.zup.vinteedois

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable

@Controller("/api/notas")
class NotaFiscalController(val notaFiscalRepository: NotaFiscalRepository) {

    @Get("/{id}")
    fun listarNotaFiscalPorId(@PathVariable id :Long) : HttpResponse<Any> {
        val transacoes = notaFiscalRepository.buscarNotaFiscalCompleta(id)
        return HttpResponse.ok(NotaFiscalResponse(transacoes))
    }
}