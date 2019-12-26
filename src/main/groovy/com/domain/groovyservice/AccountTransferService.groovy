package com.domain.groovyservice

import com.domain.pojo.Account

interface AccountTransferService {
    boolean accountTransfer(Account accountFrom, Account accountTo) throws RuntimeException
    boolean accountTransfer(Account accountFrom, Account accountTo, long amount, String transferType)
    boolean accountTransfer(Account accountFrom, Account accountTo, long defaultAmount)
    boolean accountInternationalTransfer(Account accountFrom, Account accountTo, long defaultAmount)
    boolean isBankOpen()
}
