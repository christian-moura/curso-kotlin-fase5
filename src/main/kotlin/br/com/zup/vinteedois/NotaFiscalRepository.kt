package br.com.zup.vinteedois

import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface NotaFiscalRepository : JpaRepository<NotaFiscal, Long> {

    @Query("select n from NotaFiscal n join n.itens i where n.id = :id")
    fun buscarNotaFiscalCompleta (id: Long): NotaFiscal?

//    @Query (nativeQuery = true, value =  "select * from nota_fiscal n inner join item_de_nota i on n.id  = i.nota_fiscal_id where n.id = :id")
//    fun buscarNotaFiscalCompleta (id: Long): NotaFiscal?
}