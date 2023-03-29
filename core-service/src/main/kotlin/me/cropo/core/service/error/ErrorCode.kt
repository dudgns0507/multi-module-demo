package me.cropo.core.service.error

enum class ErrorCode(
    private val status: Int,
    private val code: Int,
    private val message: String
) {
    USER_ALREADY_EXIST(400, 101, "User already exist.");

    fun getErrorBody(): ErrorBody {
        return ErrorBody(status, code, message)
    }
}

