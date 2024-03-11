package kotlinRepo.reporepo.domain.notice

import kotlinRepo.reporepo.domain.notice.dto.response.NoticeResponse
import kotlinRepo.reporepo.domain.notice.usecase.GetNoticeDetailsUseCase
import kotlinRepo.reporepo.domain.notice.dto.response.NoticesResponse
import kotlinRepo.reporepo.domain.notice.usecase.GetNoticesUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/notices")
class NoticeWebAdapter (
    private val getNoticesUseCase: GetNoticesUseCase,
    private val getNoticeDetailsUseCase: GetNoticeDetailsUseCase,
) {
    @GetMapping
    fun getNoticeList(): NoticesResponse {
        return getNoticesUseCase.execute()
    }

    @GetMapping("/{notice-id}")
    fun getNoticeDetails(@PathVariable("notice-id") noticeId: UUID) : NoticeResponse {
        return getNoticeDetailsUseCase.execute(noticeId)
    }
}
