package me.cropo.data.smt.controller

import me.cropo.core.service.ServiceResult
import me.cropo.data.smt.model.dto.UserDTO
import me.cropo.data.smt.service.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/user")
class UserController {

    @Autowired
    private lateinit var userService: UserServiceImpl

    @PostMapping("/signup")
    fun postSignUpInsurance(
        @RequestParam("name") name: String,
        @RequestParam("rrn") rrn: String
    ): ResponseEntity<*> {
        val userDTO = UserDTO(
            name = name,
            rrn = rrn
        )

        val result = userService.signUp(userDTO)

        return when (result) {
            is ServiceResult.Success -> ResponseEntity.ok(userDTO)
            is ServiceResult.Fail -> ResponseEntity.badRequest()
                .body(result.errorCode.getErrorBody())
        }
    }
}