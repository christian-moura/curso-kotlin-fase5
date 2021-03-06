package br.com.zup.dezesseis

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Introspected
data class CarroRequest(
    @field:NotBlank @field:Size(max = 60) val modelo: String,
    @field:NotBlank @field:Pattern(regexp = "[A-Z]{3}[0-9][0-9A-Z][0-9]{2}") val placa: String
) {
    fun toCarro(): Carro {
        return Carro(modelo, placa)
    }
}