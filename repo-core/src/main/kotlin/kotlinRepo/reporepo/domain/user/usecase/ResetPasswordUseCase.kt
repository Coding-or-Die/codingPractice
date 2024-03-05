package kotlinRepo.reporepo.domain.user.usecase

import kotlinRepo.reporepo.common.annotation.UseCase
import kotlinRepo.reporepo.domain.user.dto.request.ResetPasswordRequest
import kotlinRepo.reporepo.domain.user.exception.UserNotFoundException
import kotlinRepo.reporepo.domain.user.model.User
import kotlinRepo.reporepo.domain.user.service.UserService

@UseCase
class ResetPasswordUseCase(
    private val userService: UserService
) {
    fun execute(request: ResetPasswordRequest) {

        //TODO AWS-SES 로 이메일 인증 받기

        val userByEmail = userService.queryUserByEmail(request.email)

        val userByAccountId = userService.queryUserByAccountId(request.accountId)

        val user = if (userByEmail.id == userByAccountId.id) userByEmail else throw UserNotFoundException

        userService.saveUser(User(
            id = user.id,
            accountId = user.accountId,
            email = user.email,
            password = request.newPassword,
            userName = user.userName
        ))


    }
}