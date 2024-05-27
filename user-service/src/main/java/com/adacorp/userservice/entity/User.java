package com.adacorp.userservice.entity;

import com.adacorp.userservice.enums.Genre;
import com.adacorp.userservice.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utilisateur")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO )
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "prenom")
    private String firstName;
    @Column(name = "nom")
    private String lastName;
    @Column(name = "login")
    private String login;
    @Column(name = "motdepasse")
    private String password;
    private String email;
    @Column(name = "date_naissance")
    private LocalDate dateNaissance;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Genre genre;


}
