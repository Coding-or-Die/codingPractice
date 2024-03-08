package kotlinRepo.reporepo.domain.notice

import kotlinRepo.reporepo.domain.notice.dto.response.NoticeResponse
import kotlinRepo.reporepo.domain.notice.usecase.GetNoticeListUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/notice")
class NoticeWebAdapter (
    private val getNoticeListUseCase: GetNoticeListUseCase
) {
    @GetMapping
    fun getNoticeList(): List<NoticeResponse> {
        return getNoticeListUseCase.execute()
    }
}
