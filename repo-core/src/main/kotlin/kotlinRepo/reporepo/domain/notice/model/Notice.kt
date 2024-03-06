package kotlinRepo.reporepo.domain.notice.model

import kotlinRepo.reporepo.common.annotation.Aggregate
import kotlinRepo.reporepo.domain.user.model.User
import java.sql.Date
import java.time.LocalDateTime
import java.util.UUID

@Aggregate
data class Notice (
    val id: UUID = UUID(0, 0),

    val title: String,

    val subtitle: String,

    val createAt: LocalDateTime,

    val writerId: UUID
)
