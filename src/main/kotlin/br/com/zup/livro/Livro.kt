package br.com.zup.livro

import br.com.zup.autor.Autor
import java.time.LocalDate
import javax.persistence.*

@Entity
class Livro(
    @Column(nullable = false) val titulo: String?,
    @Column(nullable = false) val isbn: String?,
    @Column(nullable = false) val dataPublicaco: LocalDate?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @ManyToOne
    var autor:Autor? = null
}