package com.domain.pojo

import groovy.transform.Canonical

@Canonical
class Account {
    def accountType
    long accountNumber
    def status
    long amount
    Customer customer
}
