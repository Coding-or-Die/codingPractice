package kotlinRepo.reporepo.domain.user.dto.response

import kotlinRepo.reporepo.domain.user.model.User

data class MypageResponse(

    val username: String,

    val accountId: String,

) {
    companion object {
        fun of(user : User) = MypageResponse(user.userName, user.accountId)
    }
}
