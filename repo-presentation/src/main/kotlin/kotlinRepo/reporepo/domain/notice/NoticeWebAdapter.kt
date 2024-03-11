package kotlinRepo.reporepo.domain.notice

import kotlinRepo.reporepo.domain.notice.dto.response.NoticeResponse
import kotlinRepo.reporepo.domain.notice.dto.response.NoticesResponse
import kotlinRepo.reporepo.domain.notice.usecase.GetNoticesUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/notices")
class NoticeWebAdapter (
    private val getNoticesUseCase: GetNoticesUseCase
) {
    @GetMapping
    fun getNoticeList(): NoticesResponse {
        return getNoticesUseCase.execute()
    }
}
