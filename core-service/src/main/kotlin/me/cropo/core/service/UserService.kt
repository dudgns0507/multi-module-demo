package me.cropo.core.service


interface UserService<T> {
    fun signUp(userInfo: T): ServiceResult<T>
}