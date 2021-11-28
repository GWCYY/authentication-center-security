package com.fx.authentication.controller;

import com.fx.authentication.entity.SysUser;
import com.fx.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("users")
    public String getUser() {
        List<SysUser> users = userRepository.findAll();
        return users.get(0).getUsername();
    }
}
