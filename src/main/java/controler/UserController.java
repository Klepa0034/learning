package controler;

import entity.User;
import service.impl.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class UserController {
    private UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    public List<User> findAll() throws SQLException {
        return userServiceImpl.findAll();
    }

    public void insert(User user) throws SQLException {
        userServiceImpl.insert(user);
    }

    public void update(User user) throws SQLException {
        userServiceImpl.update(user);
    }

    public void deleteById(int id) throws SQLException {
        userServiceImpl.deleteById(id);
    }

}
