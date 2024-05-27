package com.adacorp.userservice.dto;

import com.adacorp.userservice.entity.User;
import com.adacorp.userservice.enums.Genre;
import com.adacorp.userservice.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserReqDto {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private LocalDate dateNaissance;
    private Role role;
    private Genre genre;

public User toUser(){
    return User.builder()
            .firstName(firstName)
            .lastName(lastName)
            .login(login)
            .password(password)
            .email(email)
            .role(role)
            .genre(genre)
            .dateNaissance(dateNaissance)
            .build();
}

}
