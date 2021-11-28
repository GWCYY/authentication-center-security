package com.fx.authentication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptableProperties
@SpringBootApplication
public class AuthenticationCenterSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationCenterSecurityApplication.class, args);
    }

}
