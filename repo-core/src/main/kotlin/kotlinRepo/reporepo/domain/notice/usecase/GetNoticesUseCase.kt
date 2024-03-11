package kotlinRepo.reporepo.domain.notice.usecase

import kotlinRepo.reporepo.common.annotation.UseCase
import kotlinRepo.reporepo.domain.notice.dto.response.NoticesResponse
import kotlinRepo.reporepo.domain.notice.service.NoticeService

@UseCase
class GetNoticesUseCase (
    private val noticeService: NoticeService
) {
    fun execute() : NoticesResponse {
        return noticeService.queryNoticeOrderByCreateAtDesc()
    }
}
