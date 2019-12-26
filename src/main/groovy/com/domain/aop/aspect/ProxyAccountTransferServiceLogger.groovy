package com.domain.aop.aspect


import com.domain.pojo.Account
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*
import org.springframework.stereotype.Component

@Aspect
@Component
class ProxyAccountTransferServiceLogger {

    @Pointcut('execution(* com.domain.groovyservice.AccountTransferService.accountTransfer(..))')
        def void accountTransfer() {
    }

    @Before('accountTransfer())')
    def boolean logBeforeAccountTransfer(JoinPoint joinPoint) {

        Account acct = joinPoint.getArgs()[0]
        println "logging before account transfer for customer: ${acct.customer.firstName} ${acct.customer.lastName}"
    }

    @After('accountTransfer()')
    def boolean logAfterReturnAccountTransfer(JoinPoint joinPoint) {

        Account acct = joinPoint.getArgs()[0]
        println "logging after account transfer for customer: ${acct.customer.firstName} ${acct.customer.lastName}"
    }

    @AfterReturning('accountTransfer()')
    def boolean logAfterReturningAccountTransfer(JoinPoint joinPoint) {

        Account acct = joinPoint.getArgs()[0]
        println "logging after returning account transfer for customer: ${acct.customer.firstName} ${acct.customer.lastName}"
    }

    @AfterThrowing("accountTransfer()")
    def boolean logAfterThrowingAccountTransfer() {
        println "After throwing --> logging after account transfer for customer"
    }

    @Around("execution (* com.domain.groovyservice.AccountTransferService.accountInternationalTransfer(..))")
    def boolean logAfterAroundAccountInternationalTransfer(ProceedingJoinPoint pjp) {
        println "***before*** calling accountInternationalTransfer"
        Object result = pjp.proceed()
        println "***after*** calling accountInternationalTransfer"
    }
}
