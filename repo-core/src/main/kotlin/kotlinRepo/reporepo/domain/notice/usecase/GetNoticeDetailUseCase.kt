package kotlinRepo.reporepo.domain.notice.usecase

import kotlinRepo.reporepo.common.annotation.ReadOnlyUseCase
import kotlinRepo.reporepo.domain.notice.dto.response.NoticeDetailResponse
import kotlinRepo.reporepo.domain.notice.service.NoticeService
import java.util.UUID

@ReadOnlyUseCase
class GetNoticeDetailUseCase (
    private val noticeService: NoticeService
) {
    fun execute(noticeId: UUID) : NoticeDetailResponse {
        return NoticeDetailResponse.of(
            noticeService.queryNoticeById(noticeId)
        )
    }
}
