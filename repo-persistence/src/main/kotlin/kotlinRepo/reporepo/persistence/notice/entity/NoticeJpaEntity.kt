package kotlinRepo.reporepo.persistence.notice.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import kotlinRepo.reporepo.persistence.BaseUUIDEntity
import kotlinRepo.reporepo.persistence.user.entity.UserJpaEntity
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "tbl_notice")
class NoticeJpaEntity (

    id: UUID?,

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    val title: String,

    @Column(columnDefinition = "VARCHAR(1000)", nullable = false)
    val content: String,

    override val createdAt: LocalDateTime,

    @ManyToOne
    val writer: UserJpaEntity?


) : BaseUUIDEntity(id)
