package kotlinRepo.reporepo.persistence.notice.mapper

import kotlinRepo.reporepo.domain.notice.model.Notice
import kotlinRepo.reporepo.persistence.GenericMapper
import kotlinRepo.reporepo.persistence.notice.entity.NoticeJpaEntity
import kotlinRepo.reporepo.persistence.user.repository.UserJpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class NoticeMapper(
    private val userJpaRepository: UserJpaRepository
) : GenericMapper<Notice, NoticeJpaEntity> {

    override fun toDomain(entity: NoticeJpaEntity?): Notice? {
        return entity?.let {
            Notice(
                id = it.id!!,
                title = it.title,
                subtitle = it.subtitle,
                writerId = it.writer?.id!!,
                createAt = it.createAt
            )
        }
    }

    override fun toEntity(domain: Notice): NoticeJpaEntity {
        val writer = domain.writerId.let { userJpaRepository.findByIdOrNull(it) }

        return NoticeJpaEntity(
            id = domain.id,
            title = domain.title,
            subtitle = domain.subtitle,
            writer = writer,
            createAt = domain.createAt
        )
    }
}
