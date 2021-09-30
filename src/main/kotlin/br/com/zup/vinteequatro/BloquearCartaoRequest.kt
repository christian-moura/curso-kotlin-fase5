package br.com.zup.vinteequatro

import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.core.annotation.Introspected
import java.time.LocalDate

@Introspected
class BloquearCartaoRequest(
    val titular: String,
    @field:JsonFormat(pattern = "yyyy-MM") val expiraEm: LocalDate,
    val cvv: Int
) {
}