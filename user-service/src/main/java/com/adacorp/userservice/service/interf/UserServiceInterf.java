package com.adacorp.userservice.service.interf;

import com.adacorp.userservice.dto.UserLoginDto;
import com.adacorp.userservice.dto.UserPwdDto;
import com.adacorp.userservice.dto.UserReqDto;
import com.adacorp.userservice.dto.UserRespDto;
import com.adacorp.userservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public interface UserServiceInterf {
    Map<String, Object> createUsers(UserReqDto userReqDto);
    List<UserRespDto> getAllUsers();
    UserRespDto getUserByLogin(String login);
    UserPwdDto getPasswordByUserId(UUID userid);
    UserLoginDto getLoginById(UUID userid);

    UserPwdDto updateById(UUID userid, UserPwdDto userPwdDto);
}
