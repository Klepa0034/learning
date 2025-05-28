package controler;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public List<User> findAll() throws SQLException {
        return userService.findAll();
    }

    public void insert(User user) throws SQLException {
        userService.insert(user);
    }

    public void update(User user) throws SQLException {
        userService.update(user);
    }

    public void deleteById(int id) throws SQLException {
        userService.deleteById(id);
    }

}
