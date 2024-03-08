package kotlinRepo.reporepo.domain.notice.model

import kotlinRepo.reporepo.common.annotation.Aggregate
import java.time.LocalDateTime
import java.util.UUID

@Aggregate
data class Notice (

    val id: UUID = UUID(0, 0),

    val title: String,

    val content: String,

    val createdAt: LocalDateTime,

    val writerId: UUID
)
