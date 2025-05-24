package service.impl;

import entity.User;
import repository.impl.UserRepositoryImpl;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepositoryImpl userRepositoryImpl;

    public UserServiceImpl(UserRepositoryImpl userRepositoryImpl) {
        this.userRepositoryImpl = userRepositoryImpl;
    }

    public List<User> findAll() throws SQLException {
        List<User> all = userRepositoryImpl.findAll();
        if (all.isEmpty()) {
            throw new RuntimeException("Пользователи не найдены");
        }
        return all;
    }

    public void insert(User user) throws SQLException {
        userRepositoryImpl.insert(user);
    }

    public void update(User user) throws SQLException {
        userRepositoryImpl.update(user);
    }

    public void deleteById(int id) throws SQLException {
        userRepositoryImpl.deleteById(id);
    }
}
