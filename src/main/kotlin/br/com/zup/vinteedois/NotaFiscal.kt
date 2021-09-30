package br.com.zup.vinteedois

import br.com.zup.vinteedois.itemdenota.ItemDeNota
import java.time.LocalDate
import javax.persistence.*

@Entity
class NotaFiscal(

    val numero: String,
    val serie: String,
    val data: LocalDate,

// outros atributos
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "nota_fiscal_id")
    var itens: List<ItemDeNota?>? =  null

}