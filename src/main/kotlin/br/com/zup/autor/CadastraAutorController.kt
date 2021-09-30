package br.com.zup.autor

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import io.micronaut.validation.validator.Validator
import javax.inject.Inject
import javax.validation.Valid

@Validated
@Controller("/api/autores")
class CadastraAutorController(val autorRepository: AutorRepository) {
    @Inject
    lateinit var validator: Validator

    @Post
    fun cadastra(@Body autorRequest: AutorRequest): HttpResponse<Any> {
        val listaViolacoes = validator.validate(autorRequest)
        if (listaViolacoes.isNotEmpty()) return HttpResponse.badRequest(listaViolacoes.toString())
        val autor = autorRepository.save(autorRequest.toAutor())
        val uri = UriBuilder.of("/autores/{id}")
            .expand(mutableMapOf(Pair("id", autor.id)))
        return HttpResponse.created<Any?>(uri).body(autor)
    }

    @Put("/{id}")
    fun editar(@PathVariable id: Long, @Body @Valid autorRequest: AutorRequest): HttpResponse<Any> {
        val autor = autorRepository.findById(id)
        if (autor.isEmpty) return HttpResponse.notFound()
        autor.get().atualizar(autorRequest)
        autorRepository.update(autor.get())
        return HttpResponse.ok()
    }

    @Delete("/{id}")
    fun deletar(@PathVariable id: Long): HttpResponse<Any> {
        val autor = autorRepository.findById(id)
        if (autor.isPresent) autorRepository.deleteById(id)
        return HttpResponse.ok()
    }
}
