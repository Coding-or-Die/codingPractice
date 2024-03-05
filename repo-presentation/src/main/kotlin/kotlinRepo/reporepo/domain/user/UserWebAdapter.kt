package kotlinRepo.reporepo.domain.user

import jakarta.validation.Valid
import kotlinRepo.reporepo.domain.auth.dto.response.TokenResponse
import kotlinRepo.reporepo.domain.user.dto.request.*
import kotlinRepo.reporepo.domain.user.dto.response.MypageResponse
import kotlinRepo.reporepo.domain.user.usecase.LoginUseCase
import kotlinRepo.reporepo.domain.user.usecase.MypageUseCase
import kotlinRepo.reporepo.domain.user.usecase.ResetPasswordUseCase
import kotlinRepo.reporepo.domain.user.usecase.SignupUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
@RestController
class UserWebAdapter (
    private val signupUseCase: SignupUseCase,
    private val loginUseCase: LoginUseCase,
    private val mypageUseCase: MypageUseCase,
    private val resetPasswordUseCase: ResetPasswordUseCase
) {

    @PostMapping("/signup")
    fun signup(@RequestBody @Valid webRequest: SignupWebRequest) : TokenResponse {
        val request = SignupRequest(
            username =  webRequest.username,
            accountId = webRequest.accountId,
            password = webRequest.password,
            email = webRequest.email
        )
         return signupUseCase.execute(request)
    }

    @PostMapping("/login")
    fun login(@RequestBody @Valid webRequest: LoginWebRequest) : TokenResponse {
        val request = LoginRequest(
            accountId = webRequest.accountId,
            password =  webRequest.password

        )
        return loginUseCase.execute(request)
    }

    @GetMapping("/mypage")
    fun mypage() : MypageResponse {
        return mypageUseCase.execute()
    }

    @PatchMapping("/reset-password")
    fun resetPassword(@RequestBody @Valid webRequest: ResetPasswordWebRequest) {
        val request = ResetPasswordRequest(
            email = webRequest.email,
            authcode = webRequest.authcode,
            accountId = webRequest.accountId,
            newPassword = webRequest.newPassword
            )
        resetPasswordUseCase.execute(request)
    }
}
