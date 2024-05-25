package com.adacorp.userservice.services;

import com.adacorp.userservice.Entity.UserEntity;
import com.adacorp.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }


    public String deleteUserById(String deleteUserId) {
        userRepository.deleteById(UUID.fromString(deleteUserId));
        return "User with ID : "+deleteUserId+" deleted successfully !!!";
    }


    public UserEntity updateUser(UUID updateUserId, UserEntity user) {
        UserEntity update = userRepository.findById(updateUserId).orElseThrow(() -> new RuntimeException("User Not Founded"));

        UserEntity.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .build();

        return userRepository.save(update);

    }
}
