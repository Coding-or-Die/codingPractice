package kotlinRepo.reporepo.domain.notice.exception

import kotlinRepo.reporepo.common.error.RepoRepoException
import kotlinRepo.reporepo.domain.notice.exception.error.NoticeErrorCode

object NoticeNotFoundException : RepoRepoException(
    NoticeErrorCode.NOTICE_NOT_FOUND
)
