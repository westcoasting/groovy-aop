package com.domain.groovyservice.impl

import com.domain.groovyservice.AccountTransferService
import com.domain.pojo.Account
import org.springframework.stereotype.Component

@Component
class AccountTransferServiceImpl implements AccountTransferService {

    @Override
    def boolean  accountTransfer(Account accountFrom, Account accountTo) throws RuntimeException {
        throw new RuntimeException("Could not perform transfer. Your from account has a negative balance")
    }

    @Override
    def boolean accountTransfer(Account accountFrom, Account accountTo, long amount, String accountType) {
        return false
    }

    @Override
    def boolean accountTransfer(Account accountFrom, Account accountTo, long defaultAmount) {
        return true
    }

    @Override
    boolean accountInternationalTransfer(Account accountFrom, Account accountTo, long defaultAmount) {
        return true
    }

    @Override
    boolean isBankOpen() {
        println 'Checking if account is open'
        return true
    }
}
