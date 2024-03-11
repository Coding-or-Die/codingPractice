package kotlinRepo.reporepo.domain.notice.spi

import kotlinRepo.reporepo.domain.notice.model.Notice

interface CommandNoticePort {

    fun saveNotice(notice: Notice) : Notice

}
