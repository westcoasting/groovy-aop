package com.domain.aop.aspect

import com.domain.aop.log.audit.GroovyLogAuditor
import com.domain.aop.log.audit.impl.DefaultGroovyLogAuditor
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.DeclareParents
import org.springframework.stereotype.Component

@Aspect
@Component
class LogAuditorIntroducer {

    static {
        String tst = 'hello'
    }

    @DeclareParents(value='com.domain.groovyservice.AccountTransferService+', defaultImpl= DefaultGroovyLogAuditor.class)
    public static GroovyLogAuditor logAuditor;
}
