package com.adacorp.userservice.service.impl;

import com.adacorp.userservice.dto.UserLoginDto;
import com.adacorp.userservice.dto.UserPwdDto;
import com.adacorp.userservice.dto.UserReqDto;
import com.adacorp.userservice.dto.UserRespDto;
import com.adacorp.userservice.entity.User;
import com.adacorp.userservice.repository.UserRepository;
import com.adacorp.userservice.service.interf.UserServiceInterf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserServiceInterf {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Map<String, Object> createUsers(UserReqDto userReqDto) {
        User userExist = userRepository.findByEmail(userReqDto.getEmail());
       // User userExist1 = userRepository.findByLogin(userReqDto.getLogin());
        Map<String, Object> response = new HashMap<>();

        if (userExist != null) {
        Boolean contains= userReqDto.toUser().getEmail().contains("[\\w.-]+@[\\w.-]+\\.[a-z]{2,} ");
             if (contains = true) {

              if (userExist.getEmail().equalsIgnoreCase(userReqDto.toUser().getEmail())) {
                 response.put("message", "cet utilisateur existe déjà!");
                 return response;
             }

            response.put("message", "mail non valide bien vouloir resaisir");
            return response;
        }

        }
        UserRespDto userSaved = new UserRespDto().fromUser(userRepository.save(userReqDto.toUser()));
        response.put("message", "utilisateur enregistré!!!");
        response.put("utilisateur", userSaved);
        return response;
    }

    @Override
    public List<UserRespDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserRespDto> userRespDtos = new ArrayList<>();

        for (User user : users) {
            userRespDtos.add(new UserRespDto().fromUser(user));
        }
        return userRespDtos;
    }

    @Override
    public UserPwdDto getPasswordByUserId(UUID userid) {
        return new UserPwdDto().fromUserPwd(userRepository.findById(userid).orElseThrow(()
                -> new RuntimeException("users not found!!!!")));
    }

    @Override
    public UserLoginDto getLoginById(UUID userid) {
        return new UserLoginDto().fromUserLogin(userRepository.findById(userid).orElseThrow(()
                -> new RuntimeException("user not found!!!")));
    }

    @Override
    public UserPwdDto updateById(UUID userid, UserPwdDto userPwdDto) {
        User user = userRepository.findById(userid).orElseThrow(()
                -> new RuntimeException("user not found!!!"));
        user.setPassword(userPwdDto.getPassword());
        return new UserPwdDto().fromUserPwd(userRepository.save(user));
    }


    @Override
    public UserRespDto getUserByLogin(String login) {
        return new UserRespDto().fromUser(userRepository.findByLogin(login));
    }
}
