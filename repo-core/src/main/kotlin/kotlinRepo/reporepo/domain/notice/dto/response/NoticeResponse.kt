package kotlinRepo.reporepo.domain.notice.dto.response

import kotlinRepo.reporepo.domain.notice.model.Notice
import java.time.LocalDateTime
import java.util.UUID

data class NoticeResponse (
    val id : UUID,

    val title : String,

    val subtitle : String,

    val createAt : LocalDateTime,

    val writerId : UUID

) {
    companion object {
        fun of (notice: Notice) = NoticeResponse (
            notice.id,
            notice.title,
            notice.content,
            notice.createdAt,
            notice.writerId
        )
    }
}

data class NoticesResponse (

    val notices: List<NoticeResponse>

)
