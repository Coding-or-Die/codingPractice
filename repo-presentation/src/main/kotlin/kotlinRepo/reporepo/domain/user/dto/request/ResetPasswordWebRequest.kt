package kotlinRepo.reporepo.domain.user.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class ResetPasswordWebRequest (

    @field:NotBlank
    val email: String,

    @field:NotBlank
    val authcode: String,

    @field:NotBlank
    val accountId: String,

    @field:NotBlank
    @field:Size(min = 8, max = 20)
    val newPassword: String,


)