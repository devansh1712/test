package com.BlogApp_With_Mircroservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MainClass {
    public static void main(String[] args) {
        PasswordEncoder e = new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2B);
        System.out.println(e.encode("testing"));
    }
}
