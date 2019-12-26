package com.domain.aop.log.audit.impl

import com.domain.aop.log.audit.GroovyLogAuditor
import org.springframework.stereotype.Component

@Component
class DefaultGroovyLogAuditor implements GroovyLogAuditor {
    @Override
    void saveLogActivity() {
        println "Saving log activity for user: dummy user"
    }
}
