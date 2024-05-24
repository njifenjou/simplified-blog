package com.adacorp.userservice.dto;

import com.adacorp.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginDto {
    private String login;

    public UserLoginDto fromUserLogin(User user){
        return UserLoginDto.builder()
                .login(user.getLogin())
                .build();
    }
}
