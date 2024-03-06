package kotlinRepo.reporepo.domain.user.service

interface CheckUserService {

    fun checkUserExistsByAccountId(accountId: String)

    fun checkUserInformation(accountId: String, email: String)

}
