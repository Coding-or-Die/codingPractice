package kotlinRepo.reporepo.persistence.notice

import com.querydsl.jpa.impl.JPAQueryFactory
import kotlinRepo.reporepo.domain.notice.dto.response.NoticeResponse
import kotlinRepo.reporepo.domain.notice.dto.response.NoticesResponse
import kotlinRepo.reporepo.domain.notice.model.Notice
import kotlinRepo.reporepo.domain.notice.spi.NoticePort
import kotlinRepo.reporepo.persistence.notice.entity.QNoticeJpaEntity
import kotlinRepo.reporepo.persistence.notice.mapper.NoticeMapper
import kotlinRepo.reporepo.persistence.notice.repository.NoticeJpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class NoticePersistenceAdapter(
    private val noticeMapper: NoticeMapper,
    private val noticeJpaRepository: NoticeJpaRepository,
    private val jpaQueryFactory: JPAQueryFactory
) : NoticePort {

    override fun findAllOrderByCreateAtDesc() : NoticesResponse {
        val notice = QNoticeJpaEntity.noticeJpaEntity

        return jpaQueryFactory
            .selectFrom(notice)
            .orderBy(notice.createdAt.desc())
            .fetch()
            .map {
                NoticeResponse.of(noticeMapper.toDomain(it)!!)
            }.let {
                NoticesResponse(it)
            }
    }

    override fun findById(noticeId: UUID) = noticeMapper.toDomain(
        noticeJpaRepository.findByIdOrNull(noticeId)
    )

    override fun saveNotice(notice: Notice) = noticeMapper.toDomain(
        noticeJpaRepository.save(
            noticeMapper.toEntity(notice)
        )
    )!!
}
