package kotlinRepo.reporepo.domain.notice.service

import kotlinRepo.reporepo.common.annotation.Service

@Service
class NoticeService (
    checkNoticeService: CheckNoticeService,
    commandNoticeService: CommandNoticeService,
    getNoticeService: GetNoticeService
) : CheckNoticeService by checkNoticeService,
    CommandNoticeService by commandNoticeService,
    GetNoticeService by getNoticeService
