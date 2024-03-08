package kotlinRepo.reporepo.domain.notice.service

import kotlinRepo.reporepo.domain.notice.model.Notice
import java.util.UUID

interface GetNoticeService {

    fun queryNoticeOrderByCreateAtDesc() : List<Notice>

    fun queryNoticeById(noticeId: UUID) : Notice

}
