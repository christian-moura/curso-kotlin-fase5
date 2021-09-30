package br.com.zup.aluno

import br.com.zup.autor.AutorRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.validator.Validator
import javax.inject.Inject

@Controller("/api/alunos")
class AlunoController {

    @Inject
    lateinit var validator: Validator

    @Post
    fun cadastra(@Body alunoRequest: AutorRequest): HttpResponse<Any> {
        val listaViolacoes = validator.validate(alunoRequest)
        if (listaViolacoes.isNotEmpty()) return HttpResponse.badRequest(listaViolacoes.toString())
        return HttpResponse.ok()
    }
}