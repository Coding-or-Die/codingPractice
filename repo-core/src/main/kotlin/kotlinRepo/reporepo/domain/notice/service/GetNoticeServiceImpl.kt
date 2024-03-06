package kotlinRepo.reporepo.domain.notice.service

import kotlinRepo.reporepo.common.annotation.Service
import kotlinRepo.reporepo.domain.notice.model.Notice
import kotlinRepo.reporepo.domain.notice.spi.NoticePort

@Service
class GetNoticeServiceImpl (
    private val noticePort: NoticePort
) : GetNoticeService {

    override fun queryNoticeOrderByCreateAtDesc() =
        noticePort.findAllOrderByCreateAtDesc()

}
