package kotlinRepo.reporepo.domain.notice.usecase

import kotlinRepo.reporepo.common.annotation.ReadOnlyUseCase
import kotlinRepo.reporepo.domain.notice.dto.response.NoticesResponse
import kotlinRepo.reporepo.domain.notice.service.NoticeService

@ReadOnlyUseCase
class GetNoticesUseCase (
    private val noticeService: NoticeService
) {
    fun execute() : NoticesResponse {
        return noticeService.queryNoticeOrderByCreateAtDesc()
    }
}
