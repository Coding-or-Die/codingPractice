package kotlinRepo.reporepo.domain.user.usecase

import kotlinRepo.reporepo.common.annotation.UseCase
import kotlinRepo.reporepo.common.service.SecurityService
import kotlinRepo.reporepo.domain.user.dto.request.UpdatePasswordRequest
import kotlinRepo.reporepo.domain.user.model.User
import kotlinRepo.reporepo.domain.user.service.UserService

@UseCase
class UpdatePasswordUseCase(
    private val userService: UserService,
    private val securityService: SecurityService
) {
    fun execute(request: UpdatePasswordRequest) {

        //TODO AWS-SES 로 이메일 인증 받기 (다른 UseCase 에 새로 작성?)

        userService.checkUserInformation(request.accountId, request.email)

        val user = userService.queryUserByAccountId(request.accountId)

        userService.saveUser(User(
            id = user.id,
            accountId = user.accountId,
            email = user.email,
            password = securityService.encodePassword(request.newPassword),
            userName = user.userName
        ))
    }
}
