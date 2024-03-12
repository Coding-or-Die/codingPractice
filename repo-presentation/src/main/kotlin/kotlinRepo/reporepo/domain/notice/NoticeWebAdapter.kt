package kotlinRepo.reporepo.domain.notice

import kotlinRepo.reporepo.domain.notice.dto.response.NoticeDetailResponse
import kotlinRepo.reporepo.domain.notice.usecase.GetNoticeDetailUseCase
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
    private val getNoticeDetailUseCase: GetNoticeDetailUseCase,
) {
    @GetMapping
    fun getNotices(): NoticesResponse {
        return getNoticesUseCase.execute()
    }

    @GetMapping("/{notice-id}")
    fun getNoticeDetail(@PathVariable("notice-id") noticeId: UUID) : NoticeDetailResponse {
        return getNoticeDetailUseCase.execute(noticeId)
    }
}
