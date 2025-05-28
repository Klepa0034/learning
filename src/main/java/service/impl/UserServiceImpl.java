package service.impl;

import entity.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() throws SQLException {
        List<User> all = userRepository.findAll();
        if (all.isEmpty()) {
            throw new RuntimeException("Пользователи не найдены");
        }
        return all;
    }

    public void insert(User user) throws SQLException {
        userRepository.insert(user);
    }

    public void update(User user) throws SQLException {
        userRepository.update(user);
    }

    public void deleteById(int id) throws SQLException {
        userRepository.deleteById(id);
    }
}
