package br.com.zup.autor

import br.com.zup.livro.Livro
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Autor(
    @Column(nullable = false) var nome: String?,
    @Column(nullable = false) var email: String?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column(nullable = false)
    val criadoEm: LocalDateTime = LocalDateTime.now()
    @OneToMany(mappedBy = "autor", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var livros: List<Livro>? = null


    fun atualizar(autorRequest: AutorRequest){
        this.nome = autorRequest.nome
        this.email = autorRequest.email
    }
}
