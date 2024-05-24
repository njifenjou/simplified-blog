package com.adacorp.userservice.Entity;

import com.adacorp.userservice.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;


@Entity(name = "Utilisateur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id", updatable = false)
    private UUID userId;
    @Column(name = "prenom")
    private String firstname;
    @Column(name = "nom")
    private String lastname;
    @Column(name = "email")
    private  String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "motdepasse")
    private  String password;
    @Column(name = "datenaissance")
    private LocalDate datenaissance;
    @Column(name = "dateCreation")
    private LocalDate dateCreation;
    @Column(name = "genre")
    private Role genre;

}
