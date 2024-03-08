package kotlinRepo.reporepo.persistence

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.GenericGenerator
import java.util.UUID

@MappedSuperclass
abstract class BaseUUIDEntity(

    id: UUID?,


) : BaseTimeEntity() {
    @Id
    @GeneratedValue(generator = "timeBasedUUID")
    @GenericGenerator(name = "timeBasedUUID", strategy = "kotlinRepo.reporepo.persistence.TimeBasedUUIDGenerator")
    @Column(columnDefinition = "BINARY(16)", nullable = false)
    val id: UUID? = if (id == UUID(0, 0)) null else id
}
