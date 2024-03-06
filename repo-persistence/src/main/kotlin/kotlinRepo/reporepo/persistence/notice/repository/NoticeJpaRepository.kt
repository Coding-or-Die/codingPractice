package kotlinRepo.reporepo.persistence.notice.repository

import kotlinRepo.reporepo.persistence.notice.entity.NoticeJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface NoticeJpaRepository : JpaRepository<NoticeJpaEntity, UUID> {

    fun findAllOrderByCreateAtDesc() : Array<NoticeJpaEntity>

}
