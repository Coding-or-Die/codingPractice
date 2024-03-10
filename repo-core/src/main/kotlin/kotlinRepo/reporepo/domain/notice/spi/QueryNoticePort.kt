package kotlinRepo.reporepo.domain.notice.spi

import kotlinRepo.reporepo.domain.notice.dto.response.NoticesResponse

interface QueryNoticePort {

    fun findAllOrderByCreateAtDesc() : NoticesResponse
}
