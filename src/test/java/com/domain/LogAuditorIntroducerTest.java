package com.domain;

import com.domain.aop.audit.JavaLogAuditor;
import com.domain.client.config.SpringConfig;
import com.domain.javaservice.JavaAccountTransferService;
import com.domain.aop.log.audit.GroovyLogAuditor;
import com.domain.groovyservice.AccountTransferService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringConfig.class})
public class LogAuditorIntroducerTest {

    @Inject
    private JavaAccountTransferService javaTransferService;

    @Inject
    private AccountTransferService groovyTransferService;

    @Test
    public void testJavaAuditLogger(){
        javaTransferService.openAccount();
        JavaLogAuditor javaLogAuditor = (JavaLogAuditor) javaTransferService;
        javaLogAuditor.javaAuditLog();
        System.out.println("DONE!!!");
    }

    @Test
    public void testGroovyAuditLogger(){
        groovyTransferService.isBankOpen();
        GroovyLogAuditor groovyLogAuditor = (GroovyLogAuditor) groovyTransferService;
        groovyLogAuditor.saveLogActivity();
        System.out.println("DONE!!!");

    }
}
