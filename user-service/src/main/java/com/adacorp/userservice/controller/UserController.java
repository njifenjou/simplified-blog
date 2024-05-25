package com.adacorp.userservice.controller;

import com.adacorp.userservice.Entity.UserEntity;
import com.adacorp.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("simplified-blog/v1/users/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("get-all-users")
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("{deleteUserID}")
    public String deleteUserById(@PathVariable String deleteUserId){
        return userService.deleteUserById(deleteUserId);
    }

    @PutMapping("{updateUserById}")
    public UserEntity updateUser(@PathVariable UUID updateUserById, @RequestBody UserEntity user){
        return userService.updateUser(updateUserById, user);
    }
}
