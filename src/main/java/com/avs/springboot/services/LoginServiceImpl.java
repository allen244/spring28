package com.avs.springboot.services;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {


    @Override
    public boolean validateUser(String user, String password) {
        return user.equalsIgnoreCase("test") && password.equals("test");

    }
}
