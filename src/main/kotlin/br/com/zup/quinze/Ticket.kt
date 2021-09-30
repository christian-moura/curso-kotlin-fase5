package br.com.zup.quinze

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Ticket(
    @Column(nullable = false, length = 60) val titulo: String,
    @Column(nullable = false, length = 4000) val descricao: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    val criadoEm: LocalDateTime = LocalDateTime.now()

    @Column(nullable = false)
    val status: StatusTicket = StatusTicket.ABERTO
}