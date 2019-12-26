package com.domain.groovyservice.impl

import com.domain.groovyservice.AccountOpenService
import com.domain.pojo.Account
import com.domain.pojo.Customer
import org.springframework.stereotype.Component

@Component
class AccountOpenServiceImpl implements AccountOpenService {

    @Override
    def Account openAccount(Customer cust, String accountType, String status) {
        int newAccountNumber = getAccountNumber()
        Account acct = new Account(accountType: accountType, accountNumber: newAccountNumber, status: status, customer: cust)

        println("Opening new account to account repository for account type: ${accountType} with status: ${status}")
        //Persistence call
        println("""Opened new account to account repository for account with last name: ${cust.getLastName()}
                    type: ${accountType} with status: ${status} with account number: ${newAccountNumber}""")

        cust.accounts << acct

        return acct
    }

    @Override
    def Account openAccount(Customer cust, String accountType, long amount) {
        Random r = new Random()
        int newAccountNumber = getAccountNumber()
        Account acct = new Account(customer: cust, accountNumber: newAccountNumber, accountType: accountType, amount: amount)

        cust.accounts << acct

        println("Opening new account to account repository for account type: ${accountType} with amount: ${amount}")
        //Persistence call
        println("""Opened new account to account repository for account with last name: ${cust.getLastName()}
                    type: ${accountType} with account number: ${newAccountNumber}""")

        return acct
    }

    @Override
    Account openAccountChecking() {
        Account account = new Account(accountNumber: 432291, accountType: 'Checking')
        println "opening checking account"
        //open account persistence call
        println "opened checking account"

        return account
    }

    @Override
    Account openAccountSavings() {
        Account account = new Account(accountNumber: 986263, accountType: 'Savings')
        println "opening checking account"
        //open account persistence call
        println "opened checking account"

        return account
    }

    private int getAccountNumber() {
        Random r = new Random()
        r.nextInt((1000 - 100) + 1) + 100
    }

    @Override
    def Account openAccount(Customer customer, String accountType) {
        Random r = new Random()
        int newAccountNumber = r.nextInt((1000 - 100) + 1) + min
        Account acct = new Account(customer: customer, accountType: accountType)

        println("Opening new account to account repository for account type: ${accountType}")

        return acct
    }
}
