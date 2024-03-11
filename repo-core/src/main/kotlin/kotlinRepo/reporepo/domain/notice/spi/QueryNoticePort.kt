package kotlinRepo.reporepo.domain.notice.spi

import kotlinRepo.reporepo.domain.notice.dto.response.NoticesResponse
import kotlinRepo.reporepo.domain.notice.model.Notice
import java.util.UUID

interface QueryNoticePort {

    fun findAllOrderByCreateAtDesc() : NoticesResponsez

    fun findById(noticeId: UUID): Notice?

}
