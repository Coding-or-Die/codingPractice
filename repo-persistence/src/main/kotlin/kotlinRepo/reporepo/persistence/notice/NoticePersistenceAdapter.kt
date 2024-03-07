package kotlinRepo.reporepo.persistence.notice

import kotlinRepo.reporepo.domain.notice.model.Notice
import kotlinRepo.reporepo.domain.notice.spi.NoticePort
import kotlinRepo.reporepo.persistence.notice.mapper.NoticeMapper
import kotlinRepo.reporepo.persistence.notice.repository.NoticeJpaRepository
import org.springframework.stereotype.Component
import kotlin.streams.toList

@Component
class NoticePersistenceAdapter(
    private val noticeMapper: NoticeMapper,
    private val noticeJpaRepository: NoticeJpaRepository
) : NoticePort {

    override fun findAllOrderByCreateAtDesc() =
        noticeJpaRepository.findAll().map {noticeMapper.toDomain(it)!!}
            .stream().sorted {n1, n2 -> n1.createAt.compareTo(n2.createAt)}
            .toList().filterNotNull()


    override fun saveNotice(notice: Notice): Notice = noticeMapper.toDomain(
        noticeJpaRepository.save(
            noticeMapper.toEntity(notice)
        )
    )!!
}
