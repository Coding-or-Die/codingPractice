package kotlinRepo.reporepo.domain.notice.service

import kotlinRepo.reporepo.domain.notice.model.Notice

interface GetNoticeService {

    fun queryNoticeOrderByCreateAtDesc() : List<Notice>

}
