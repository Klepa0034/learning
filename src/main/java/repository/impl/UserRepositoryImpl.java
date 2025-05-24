package repository.impl;

import entity.User;
import manager.impl.UserConnectionManagerImpl;
import repository.UserRepository;
import result.impl.UserResultImpl;
import manager.impl.UserManagerImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private UserResultImpl userResultImpl;
    private UserManagerImpl userManagerImpl;
    private UserConnectionManagerImpl userConnectionManagerImpl;

    public UserRepositoryImpl(UserConnectionManagerImpl userConnectionManagerImpl, UserManagerImpl userManagerImpl, UserResultImpl userResultImpl) {
        this.userConnectionManagerImpl = userConnectionManagerImpl;
        this.userManagerImpl = userManagerImpl;
        this.userResultImpl = userResultImpl;
    }

    public List<User> findAll() throws SQLException {
        Statement statement = userConnectionManagerImpl.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(userManagerImpl.getSelectAllQuery("users"));
        List<User> users = userResultImpl.resultToListUsers(resultSet);
        resultSet.close();
        statement.close();
        return users;
    }

    public void update(User user) throws SQLException {
        Statement statement = userConnectionManagerImpl.getConnection().createStatement();
        statement.executeUpdate(userManagerImpl.updateQuery("users", "users_names='%s'".formatted(user.getName()), "user_id=%d".formatted(user.getId())));

    }

    public void insert(User user) throws SQLException {
        Statement statement = userConnectionManagerImpl.getConnection().createStatement();
        statement.execute(userManagerImpl.insertQuery("users", "(users_names)", "('%s')").formatted(user.getName()));
        statement.close();
    }

    public void deleteById(int id) throws SQLException {
        Statement statement = userConnectionManagerImpl.getConnection().createStatement();
        statement.execute(userManagerImpl.deleteQuery("users", "user_id=%d".formatted(id)));
    }
}

