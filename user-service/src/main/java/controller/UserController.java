package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.interf.UserServiceInterf;

import java.util.List;

@RestController
@RequestMapping("api/v1/users/")
public class UserController {
    private final UserServiceInterf userServiceInterf;
@Autowired
    public UserController(UserServiceInterf userServiceInterf) {
        this.userServiceInterf = userServiceInterf;
    }
    @GetMapping("get-all")
    public List<User> getAllusers(){
    return userServiceInterf.getAllUsers();
    }
}
