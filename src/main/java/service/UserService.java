package service;

import entity.Item;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
     List<User> findAll() throws SQLException;

     void insert(User user) throws SQLException;

     void deleteById(int id) throws SQLException;

     void update(User user) throws SQLException;
}
