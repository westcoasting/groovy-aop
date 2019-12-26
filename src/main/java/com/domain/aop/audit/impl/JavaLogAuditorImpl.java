package com.domain.aop.audit.impl;

import com.domain.aop.audit.JavaLogAuditor;

public class JavaLogAuditorImpl implements JavaLogAuditor {
    @Override
    public void javaAuditLog() {
        System.out.println("In javaAuditLog()");
    }
}
