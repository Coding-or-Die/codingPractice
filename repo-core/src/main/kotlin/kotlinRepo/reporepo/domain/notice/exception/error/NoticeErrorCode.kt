package kotlinRepo.reporepo.domain.notice.exception.error

import kotlinRepo.reporepo.common.error.ErrorProperty
import kotlinRepo.reporepo.common.error.ErrorStatus

enum class NoticeErrorCode (
    private val status: Int,
    private val message: String
) : ErrorProperty {

    NOTICE_NOT_FOUND(ErrorStatus.NOT_FOUND, "Notice Not Found");


    override fun status(): Int = status

    override fun message(): String = message
}
