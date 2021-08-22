package com.humayun.userservice.controller;

import com.humayun.userservice.VO.UserResponseWithDepartment;
import com.humayun.userservice.entity.User;
import com.humayun.userservice.repository.UserRepository;
import com.humayun.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside save user of user controller");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserResponseWithDepartment getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside save user of user controller");
        return userService.getUserWithDepartment(userId);
    }
}
