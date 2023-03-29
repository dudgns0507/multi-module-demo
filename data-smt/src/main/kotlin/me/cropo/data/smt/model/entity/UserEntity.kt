package me.cropo.data.smt.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Entity
data class UserEntity(
    @Id
    val id: UUID = UUID.randomUUID(),
    @Column
    val name: String,
    @Column
    val rrn: String,
    @Column
    val createdDate: LocalDateTime = LocalDateTime.now(),
) {
    fun getBirth(): String {
        return rrn.split("-").first()
    }

    fun getAge(): Int {
        val birthDate = LocalDateTime.parse(getBirth(), DateTimeFormatter.ofPattern("yyMMdd"))
        val currentDate = LocalDateTime.now()

        return when (currentDate.isAfter(birthDate)) {
            true -> currentDate.year - birthDate.year
            false -> 0
        }
    }
}