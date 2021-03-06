package br.com.zup.dezesseis

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository


@Repository
interface CarroRepository:JpaRepository<Carro,Long> {
     fun findByPlaca(placa: String): Carro?
}