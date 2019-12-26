package com.domain.groovyservice

import com.domain.pojo.Account
import com.domain.pojo.Customer
import org.springframework.stereotype.Component

@Component
interface AccountOpenService {

    Account openAccount(Customer customer, String accountType, String status)

    Account openAccount(Customer customer, String accountType, long amount)

    Account openAccountChecking()

    Account openAccountSavings()

    Account openAccount(Customer customer, String accountType)
}
