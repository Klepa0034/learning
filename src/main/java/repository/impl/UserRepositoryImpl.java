package repository.impl;

import entity.User;
import manager.ConnectionManager;
import manager.QueryManager;
import repository.UserRepository;
import result.impl.UserResultImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private UserResultImpl userResultImpl;
    private QueryManager queryManager;
    private ConnectionManager connectionManager;

    public UserRepositoryImpl(ConnectionManager connectionManager, QueryManager queryManager, UserResultImpl userResultImpl) {
        this.connectionManager = connectionManager;
        this.queryManager = queryManager;
        this.userResultImpl = userResultImpl;
    }

    public List<User> findAll() throws SQLException {
        Statement statement = connectionManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(queryManager.getSelectAllQuery("users"));
        List<User> users = userResultImpl.resultToListUsers(resultSet);
        resultSet.close();
        statement.close();
        return users;
    }

    public void update(User user) throws SQLException {
        Statement statement = connectionManager.getConnection().createStatement();
        statement.executeUpdate(queryManager.updateQuery("users", "users_names='%s'".formatted(user.getName()), "user_id=%d".formatted(user.getId())));

    }

    public void insert(User user) throws SQLException {
        Statement statement = connectionManager.getConnection().createStatement();
        statement.execute(queryManager.insertQuery("users", "(users_names)", "('%s')").formatted(user.getName()));
        statement.close();
    }

    public void deleteById(int id) throws SQLException {
        Statement statement = connectionManager.getConnection().createStatement();
        statement.execute(queryManager.deleteQuery("users", "user_id=%d".formatted(id)));
    }
}

