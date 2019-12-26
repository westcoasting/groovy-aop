package com.domain.client

import com.domain.client.config.SpringConfig
import com.domain.groovyservice.AccountOpenService
import com.domain.groovyservice.AccountTransferService
import com.domain.pojo.Account
import com.domain.pojo.Customer
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.stereotype.Component

import javax.inject.Inject

@Component
class AccountOpenClient {
    static final ACCOUNT_STATUS_ACTIVE = 'Active'

    @Inject
    private AccountOpenService accountOpenService

    @Inject
    private AccountTransferService accountTransferService

    static void main(String ...args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class)
        AccountOpenClient client = ctx.getBean(AccountOpenClient.class)
        client.accountOpen()
    }

    def accountOpen() {
        assert accountOpenService != null

        Customer cust = new Customer(firstName: 'Al',  lastName: 'Pacino')
        assert cust.accounts.size() == 0
        Account account =
                accountOpenService.openAccount(cust, 'Checking', ACCOUNT_STATUS_ACTIVE)
        assert cust.accounts.size() != 0

        Customer cust2 = new Customer(firstName: 'Robert',  lastName: 'Deniro')
        account = accountOpenService.openAccount(cust2, 'Savings', 500)
        assert cust2.accounts.size() != 0

        Customer cust3 = new Customer(firstName: 'Doc', lastName: 'Holliday')
        account = accountOpenService.openAccount(cust3, 'Money Market', 250)
        assert cust3.accounts.size() != 0

        accountOpenService.openAccountChecking()
        accountOpenService.openAccountSavings()
    }
}
