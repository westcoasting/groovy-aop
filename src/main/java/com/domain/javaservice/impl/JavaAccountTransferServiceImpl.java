package com.domain.javaservice.impl;

import com.domain.javaservice.JavaAccountTransferService;
import org.springframework.stereotype.Component;

@Component
public class JavaAccountTransferServiceImpl implements JavaAccountTransferService {
    @Override
    public void openAccount() {
        System.out.println("In JavaAccountTransferServiceImpl.openAccount()");
    }
}
