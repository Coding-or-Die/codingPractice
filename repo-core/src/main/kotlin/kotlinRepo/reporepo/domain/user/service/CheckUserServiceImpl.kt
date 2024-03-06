package kotlinRepo.reporepo.domain.user.service

import kotlinRepo.reporepo.common.annotation.Service
import kotlinRepo.reporepo.domain.user.exception.UserAccountIdExistsException
import kotlinRepo.reporepo.domain.user.exception.UserNotFoundException
import kotlinRepo.reporepo.domain.user.spi.QueryUserPort

@Service
class CheckUserServiceImpl(
    private val queryUserPort: QueryUserPort
) : CheckUserService {

    override fun checkUserExistsByAccountId(accountId: String){
        if(queryUserPort.existUserByAccountId(accountId)) {
            throw UserAccountIdExistsException
        }
    }

    override fun checkUserInformation(accountId: String, email: String){
        if(!queryUserPort.queryUserByAccountId(accountId)?.email.equals(email)) {
            throw UserNotFoundException
        }
    }
}
