package kotlinRepo.reporepo.global.error.exception

interface ErrorProperty {
    fun status(): Int
    fun message(): String
}