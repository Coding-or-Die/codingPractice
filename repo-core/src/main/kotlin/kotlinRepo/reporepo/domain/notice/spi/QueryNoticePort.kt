package kotlinRepo.reporepo.domain.notice.spi

import kotlinRepo.reporepo.domain.notice.model.Notice

interface QueryNoticePort {

    fun findAllOrderByCreateAtDesc() : List<Notice>
}
