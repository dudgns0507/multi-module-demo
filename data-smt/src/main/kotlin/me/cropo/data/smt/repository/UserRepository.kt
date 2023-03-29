package me.cropo.data.smt.repository

import me.cropo.data.smt.model.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findAllByNameAndRrn(name: String, rrn: String): List<UserEntity>
}