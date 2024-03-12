package kotlinRepo.reporepo.domain.notice.service

import kotlinRepo.reporepo.domain.notice.dto.response.NoticesResponse
import kotlinRepo.reporepo.domain.notice.model.Notice
import java.util.UUID

interface GetNoticeService {

    fun queryNoticeOrderByCreateAtDesc() : NoticesResponse

    fun queryNoticeById(noticeId: UUID) : Notice

}
