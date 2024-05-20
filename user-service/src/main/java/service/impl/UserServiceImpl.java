package service.impl;

import entity.User;
import service.interf.UserServiceInterf;

import java.util.List;

public class UserServiceImpl  implements UserServiceInterf {
    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}
