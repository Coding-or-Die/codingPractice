package kotlinRepo.reporepo.domain.notice

import kotlinRepo.reporepo.domain.notice.dto.response.NoticeResponse
import kotlinRepo.reporepo.domain.notice.usecase.GetNoticeDetailsUseCase
import kotlinRepo.reporepo.domain.notice.usecase.GetNoticeListUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/notice")
class NoticeWebAdapter (
    private val getNoticeListUseCase: GetNoticeListUseCase,
    private val getNoticeDetailsUseCase: GetNoticeDetailsUseCase,
) {
    @GetMapping
    fun getNoticeList(): List<NoticeResponse> {
        return getNoticeListUseCase.execute()
    }

    @GetMapping("/{notice-id}")
    fun getNoticeDetails(@PathVariable("notice-id") noticeId: UUID) : NoticeResponse {
        return getNoticeDetailsUseCase.execute(noticeId)
    }
}
