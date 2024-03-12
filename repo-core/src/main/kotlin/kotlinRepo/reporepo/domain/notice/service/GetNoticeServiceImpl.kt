package kotlinRepo.reporepo.domain.notice.service

import kotlinRepo.reporepo.common.annotation.Service
import kotlinRepo.reporepo.domain.notice.exception.NoticeNotFoundException
import kotlinRepo.reporepo.domain.notice.model.Notice
import kotlinRepo.reporepo.domain.notice.spi.NoticePort
import java.util.UUID

@Service
class GetNoticeServiceImpl (
    private val noticePort: NoticePort
) : GetNoticeService {

    override fun queryNoticeOrderByCreateAtDesc() =
        noticePort.findAllOrderByCreateAtDesc()

    override fun queryNoticeById(noticeId: UUID): Notice =
        noticePort.findById(noticeId) ?: throw NoticeNotFoundException

}
