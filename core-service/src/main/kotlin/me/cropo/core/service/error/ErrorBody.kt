package me.cropo.core.service.error

data class ErrorBody(
    val status: Int,
    val code: Int,
    val message: String
)