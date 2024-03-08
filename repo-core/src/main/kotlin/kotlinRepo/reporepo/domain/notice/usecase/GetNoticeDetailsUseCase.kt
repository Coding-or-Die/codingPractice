package kotlinRepo.reporepo.domain.notice.usecase

import kotlinRepo.reporepo.common.annotation.UseCase
import kotlinRepo.reporepo.domain.notice.dto.response.NoticeResponse
import kotlinRepo.reporepo.domain.notice.service.NoticeService
import java.util.UUID

@UseCase
class GetNoticeDetailsUseCase (
    private val noticeService: NoticeService
) {
    fun execute(noticeId: UUID) : NoticeResponse {

        return NoticeResponse.of(noticeService.queryNoticeById(noticeId))

    }
}
