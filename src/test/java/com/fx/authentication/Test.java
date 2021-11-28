package com.fx.authentication;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "fx1025fx#";
        System.out.println(encoder.encode(password));
    }
}
