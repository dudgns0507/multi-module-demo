package me.cropo.data.smt.service

import me.cropo.core.service.error.ErrorCode
import me.cropo.core.service.ServiceResult
import me.cropo.core.service.UserService
import me.cropo.data.smt.model.dto.UserDTO
import me.cropo.data.smt.model.entity.UserEntity
import me.cropo.data.smt.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService<UserDTO> {
    @Autowired
    private lateinit var userRepository: UserRepository

    override fun signUp(userInfo: UserDTO): ServiceResult<UserDTO> {
        val users = userRepository.findAllByNameAndRrn(userInfo.name, userInfo.rrn)

        return when {
            users.isNotEmpty() -> {
                ServiceResult.Fail(ErrorCode.USER_ALREADY_EXIST)
            }

            else -> {
                userRepository.save(
                    UserEntity(
                        name = userInfo.name,
                        rrn = userInfo.rrn
                    )
                )
                ServiceResult.Success(data = userInfo)
            }
        }
    }
}