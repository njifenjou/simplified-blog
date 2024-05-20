package service.interf;

import entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServiceInterf {
    List<User> getAllUsers();
}
