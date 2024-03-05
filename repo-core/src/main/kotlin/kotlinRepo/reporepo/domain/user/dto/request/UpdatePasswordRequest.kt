package kotlinRepo.reporepo.domain.user.dto.request

data class UpdatePasswordRequest (
    val email: String,

    val authcode: String,

    val accountId: String,

    val newPassword: String,
)
