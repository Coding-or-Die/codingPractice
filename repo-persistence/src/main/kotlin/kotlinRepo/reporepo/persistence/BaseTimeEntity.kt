package kotlinRepo.reporepo.persistence

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseTimeEntity(

    @Column(nullable = false, updatable = false, columnDefinition = "DATETIME(6)")
    open val createdAt: LocalDateTime = LocalDateTime.now()

)
