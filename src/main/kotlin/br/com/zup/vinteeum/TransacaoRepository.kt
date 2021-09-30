package br.com.zup.vinteeum

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable

@Repository
interface TransacaoRepository : JpaRepository<Transacao, Long> {

    fun findAllByClienteId(id: Long, paginacao: Pageable?): Page<TransacaoResponse?>?
}