package kotlinRepo.reporepo.domain.notice.spi

import kotlinRepo.reporepo.domain.notice.model.Notice
import java.util.UUID

interface QueryNoticePort {

    fun findAllOrderByCreateAtDesc() : List<Notice>

    fun findById(noticeId: UUID): Notice?

}
