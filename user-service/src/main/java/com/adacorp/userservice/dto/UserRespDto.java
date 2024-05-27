package com.adacorp.userservice.dto;

import com.adacorp.userservice.entity.User;
import com.adacorp.userservice.enums.Genre;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRespDto {
    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private Genre genre;
    private LocalDate dateNaissance;


    public UserRespDto fromUser(User user){
        return UserRespDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .login(user.getLogin())
                .genre(user.getGenre())
                .dateNaissance(user.getDateNaissance())
                .build();
    }
}
