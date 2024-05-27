package com.adacorp.userservice.repository;

import com.adacorp.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository <User, UUID> {
    User findByPassword (String password);
    User findByLoginAndEmail(String login, String email);
    User findByLogin(String login);
}
