package br.com.zup.dezesseis

import javax.persistence.*

@Entity
class Carro(
    @Column(nullable = false, length = 60) val modelo: String,
    @Column(nullable = false, unique = true) val placa: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}