package kotlinRepo.reporepo.domain.notice.service

import kotlinRepo.reporepo.domain.notice.dto.response.NoticesResponse

interface GetNoticeService {

    fun queryNoticeOrderByCreateAtDesc() : NoticesResponse

}
