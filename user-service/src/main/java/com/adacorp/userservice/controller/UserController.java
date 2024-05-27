package com.adacorp.userservice.controller;

import com.adacorp.userservice.dto.UserLoginDto;
import com.adacorp.userservice.dto.UserPwdDto;
import com.adacorp.userservice.dto.UserReqDto;
import com.adacorp.userservice.dto.UserRespDto;
import com.adacorp.userservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.adacorp.userservice.service.interf.UserServiceInterf;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users/")
public class UserController {
    private final UserServiceInterf userServiceInterf;

    @Autowired
    public UserController(UserServiceInterf userServiceInterf) {
        this.userServiceInterf = userServiceInterf;
    }

    @GetMapping("get-all")
    public List<UserRespDto> getAllUsers() {
        return userServiceInterf.getAllUsers();
    }

    @PostMapping("create")
    public Map<String, Object> createUsers(@RequestBody UserReqDto userReqDto) {
        return userServiceInterf.createUsers(userReqDto);
    }

    @GetMapping("{login}")
    public UserRespDto getUserByLogin(@PathVariable String login) {
        return userServiceInterf.getUserByLogin(login);
    }

    @GetMapping("getPassword/{userid}")
    public UserPwdDto getPasswordByUserId(@PathVariable UUID userid) {
        return userServiceInterf.getPasswordByUserId(userid);
    }

    @GetMapping("getLogin/{userid}")
    public UserLoginDto getLoginById(@PathVariable UUID userid) {
        return userServiceInterf.getLoginById(userid);
    }

    @PutMapping("{userid}")
    public UserPwdDto updateById(@PathVariable UUID userid, @RequestBody UserPwdDto userPwdDto){
        return userServiceInterf.updateById(userid,userPwdDto);
    }
}
