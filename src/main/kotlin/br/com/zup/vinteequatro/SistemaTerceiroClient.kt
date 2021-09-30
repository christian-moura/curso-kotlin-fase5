package br.com.zup.vinteequatro

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client
import java.util.*
import javax.validation.Valid

@Client("https://api.de.terceiro.com/")
interface SistemaTerceiroClient {

    @Post("api/cartoes/{idCartao}/bloquear")
    fun bloqueia(
        @Header(name = "X-Request-Id", value = "\${UUID.randomUUID()}") requestId : UUID,
        @PathVariable idCartao : String,
        @Valid bloquearCartaoRequest : BloquearCartaoRequest
    ) : HttpResponse<Any>

}