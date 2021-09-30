package br.com.zup.aluno

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class AlunoRequest(
    @field:NotBlank val nome: String,
    @field:NotBlank  @field:Email @field:Size(max = 42) val email: String,
    @field:NotBlank  @field:Min(18) val idade: Int
) {
}