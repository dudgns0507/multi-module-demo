package me.cropo.core.service

import me.cropo.core.service.error.ErrorCode

sealed class ServiceResult<out T> {
    data class Success<T>(
        val data: T
    ): ServiceResult<T>()

    data class Fail(
        val errorCode: ErrorCode
    ): ServiceResult<Nothing>()
}
