package kotlinRepo.reporepo.domain.notice.usecase

import kotlinRepo.reporepo.common.annotation.UseCase
import kotlinRepo.reporepo.domain.notice.dto.response.NoticeResponse
import kotlinRepo.reporepo.domain.notice.service.NoticeService

@UseCase
class GetNoticeListUseCase (
    private val noticeService: NoticeService
) {
    fun execute() : List<NoticeResponse> {
        return noticeService.queryNoticeOrderByCreateAtDesc()
            .map(NoticeResponse.Companion::of)
    }
}
