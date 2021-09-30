package br.com.zup.quatorze

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Introspected
data class ClienteRequest(
    @field:NotBlank val nome: String,
    @field:NotBlank @field:Email val email: String
) {
    fun toCliente(): Cliente {
        return Cliente(nome, email)
    }
}