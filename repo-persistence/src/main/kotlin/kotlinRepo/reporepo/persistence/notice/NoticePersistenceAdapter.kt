package kotlinRepo.reporepo.persistence.notice

import kotlinRepo.reporepo.domain.notice.model.Notice
import kotlinRepo.reporepo.domain.notice.spi.NoticePort
import kotlinRepo.reporepo.persistence.notice.mapper.NoticeMapper
import kotlinRepo.reporepo.persistence.notice.repository.NoticeJpaRepository
import org.springframework.stereotype.Component

@Component
class NoticePersistenceAdapter(
    private val noticeMapper: NoticeMapper,
    private val noticeJpaRepository: NoticeJpaRepository
) : NoticePort {

    override fun findAllOrderByCreateAtDesc() =
        noticeJpaRepository.findAllOrderByCreateAtDesc().map {it -> noticeMapper.toDomain(it)!!}

    override fun saveNotice(notice: Notice): Notice = noticeMapper.toDomain(
        noticeJpaRepository.save(
            noticeMapper.toEntity(notice)
        )
    )!!
}
