package kotlinRepo.reporepo.global.security

import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import java.util.*
import javax.crypto.SecretKey

@Configuration
class SecurityProperties(
    @Value("\${secret.secretKey}")
    secretKey: String,

    @Value("\${secret.accessExp}")
    val accessExp: Int,

    @Value("\${secret.refreshExp}")
    val refreshExp: Int
) {
    val secretKey: SecretKey = Keys.hmacShaKeyFor(
        Base64.getEncoder().encodeToString(secretKey.toByteArray())
            .toByteArray(Charsets.UTF_8)
    )
}