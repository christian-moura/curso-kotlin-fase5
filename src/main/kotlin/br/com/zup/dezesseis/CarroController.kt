package br.com.zup.dezesseis

import br.com.zup.handler.Error
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/api/carros")
class CarroController(val carroRepository: CarroRepository) {

    @Post
    fun cadastra(@Body @Valid carroRequest: CarroRequest): HttpResponse<Any> {
        val existeCarro = carroRepository.findByPlaca(carroRequest.placa)
        if (existeCarro != null) return HttpResponse.badRequest(
            Error(
                "placa",
                "Já existe carro com a placa informada."
            )
        )

        val carro = carroRequest.toCarro()
        carroRepository.save(carro)
        val uri = UriBuilder.of("/carros/{id}")
            .expand(mutableMapOf(Pair("id", carro.id)))
        return HttpResponse.created(uri)
    }
}