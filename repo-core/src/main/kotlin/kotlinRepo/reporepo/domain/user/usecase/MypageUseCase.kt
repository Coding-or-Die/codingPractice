package kotlinRepo.reporepo.domain.user.usecase

import kotlinRepo.reporepo.common.annotation.UseCase
import kotlinRepo.reporepo.domain.user.dto.response.MypageResponse
import kotlinRepo.reporepo.domain.user.service.UserService

@UseCase
class MypageUseCase (
    private val userService: UserService
) {
    fun execute() : MypageResponse {
        val user = userService.getCurrentUser()

        return MypageResponse.of(user)
    }
}