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
public class UserPwdDto {
    private String password;

    public UserPwdDto fromUserPwd(User user){
        return UserPwdDto.builder()
                .password(user.getPassword())
                .build();
    }
}
