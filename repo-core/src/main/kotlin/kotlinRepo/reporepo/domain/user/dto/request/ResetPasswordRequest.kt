package kotlinRepo.reporepo.domain.user.dto.request

data class ResetPasswordRequest (
    val email: String,

    val authcode: String,

    val accountId: String,

    val newPassword: String,
)