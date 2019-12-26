package com.domain.aop.mixins;

import com.domain.aop.audit.JavaLogAuditor;
import com.domain.aop.audit.impl.JavaLogAuditorImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAuditIntroducer {

    @DeclareParents(value="com.domain.javaservice.JavaAccountTransferService+", defaultImpl= JavaLogAuditorImpl.class)
    public static JavaLogAuditor logAuditor;
}
