package br.com.zup.vinteeum

import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import java.time.LocalDateTime

@Introspected
data class TransacaoResponse(
    val descricao: String,
    val valor: BigDecimal,
    @field:JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") val criadaEm : LocalDateTime
)