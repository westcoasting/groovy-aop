package com.domain.client

import com.domain.client.config.SpringConfig
import com.domain.aop.log.audit.GroovyLogAuditor
import com.domain.groovyservice.AccountTransferService
import com.domain.pojo.Account
import com.domain.pojo.Customer
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.stereotype.Component

import javax.inject.Inject

@Component
class AccountTransferClient {
    static final ACCOUNT_STATUS_ACTIVE = 'Active'
    static final ACCOUNT_STATUS_FINAL = 'Closed'

    @Inject
    private AccountTransferService accountTransferService

    static void main(String ...args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class)

        AccountTransferClient client = ctx.getBean(AccountTransferClient.class)
        client.accountTransfer()
    }

    def accountTransfer() {
        assert accountTransferService != null
        Customer cust1 = new Customer(firstName: 'Al',  lastName: 'Pacino')
        Customer cust2 = new Customer(firstName: 'Robert',  lastName: 'Deniro')

        Account accountFrom1 = new Account(accountType: 'Checking', status: 'PendingApproval', customer: cust1)
        Account accountTo1 = new Account(accountType: 'Savings', status: 'PendingApproval', customer: cust1)

        Account accountFrom2 = new Account(accountType: 'Checking', status: 'PendingApproval', customer: cust2)
        Account accountTo2 = new Account(accountType: 'Savings', status: 'PendingApproval', customer: cust2)

        println accountTransferService.accountTransfer(accountFrom1, accountTo1, 250, 'Checking')
        println accountTransferService.accountTransfer(accountFrom2, accountTo2, 500)

        println "*****INTERNATIONAL TRANSFER*****"
        accountTransferService.accountInternationalTransfer(accountFrom1, accountFrom2, 1000)
        println "*****INTERNATIONAL TRANSFER*****"

        try {
            accountTransferService.accountTransfer(accountFrom1, accountFrom2)
        } catch (Exception ex) {
            ex.printStackTrace()
        }

//        LogAuditor logAuditor = accountTransferService
        GroovyLogAuditor logAuditor = (GroovyLogAuditor) accountTransferService
        logAuditor.saveLogActivity()
    }
}
