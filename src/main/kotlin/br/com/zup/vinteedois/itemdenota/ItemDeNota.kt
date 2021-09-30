package br.com.zup.vinteedois.itemdenota

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class ItemDeNota(

    val valor: BigDecimal,
    val quantidade: Int,
    // outro atributos
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}