package kotlinRepo.reporepo.persistence.notice

import com.querydsl.jpa.impl.JPAQueryFactory
import kotlinRepo.reporepo.domain.notice.model.Notice
import kotlinRepo.reporepo.domain.notice.spi.NoticePort
import kotlinRepo.reporepo.persistence.notice.entity.QNoticeJpaEntity
import kotlinRepo.reporepo.persistence.notice.mapper.NoticeMapper
import kotlinRepo.reporepo.persistence.notice.repository.NoticeJpaRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class NoticePersistenceAdapter(
    private val noticeMapper: NoticeMapper,
    private val noticeJpaRepository: NoticeJpaRepository,
    private val jpaQueryFactory: JPAQueryFactory
) : NoticePort {

    override fun findAllOrderByCreateAtDesc() : List<Notice> {
        val notice = QNoticeJpaEntity.noticeJpaEntity

        return jpaQueryFactory
            .selectFrom(notice)
            .orderBy(notice.createdAt.desc())
            .fetch()
            .map {
                noticeMapper.toDomain(it)!!
            }
    }

    override fun findById(noticeId: UUID) : Notice? {
        val notice = QNoticeJpaEntity.noticeJpaEntity

        return jpaQueryFactory
            .selectFrom(notice)
            .where(notice.id.eq(noticeId))
            .orderBy(notice.createdAt.desc())
            .fetch()
            .first().run {
                noticeMapper.toDomain(this)!!
            }
    }

    override fun saveNotice(notice: Notice) = noticeMapper.toDomain(
        noticeJpaRepository.save(
            noticeMapper.toEntity(notice)
        )
    )!!
}
