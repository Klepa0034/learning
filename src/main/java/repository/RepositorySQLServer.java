package repository;

import entity.Users;
import manager.ConectionManagerSQLRServer;
import result.ResultUsers;
import sqlManager.SqlServerManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class RepositorySQLServer {
    private ResultUsers resultUsers;
    private SqlServerManager sqlServerManager;
    private ConectionManagerSQLRServer conectionManagerSQLRServer;

    public RepositorySQLServer(ConectionManagerSQLRServer conectionManagerSQLRServer, SqlServerManager sqlServerManager, ResultUsers resultUsers) {
        this.conectionManagerSQLRServer = conectionManagerSQLRServer;
        this.sqlServerManager = sqlServerManager;
        this.resultUsers = resultUsers;
    }

    public List<Users> findAll() throws SQLException {
        Statement statement = conectionManagerSQLRServer.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlServerManager.getSelectAllQuery("users"));
        List<Users> users = resultUsers.resultToListUsers(resultSet);
        resultSet.close();
        statement.close();
        return users;
    }

    public void update(Users users) throws SQLException {
        Statement statement = conectionManagerSQLRServer.getConnection().createStatement();
        statement.executeUpdate(sqlServerManager.updateQuery("users", "users_names='%s'".formatted(users.getUsers_names()), "user_id=%d".formatted(users.getUser_id())));

    }

    public void insert(Users users) throws SQLException {
        Statement statement = conectionManagerSQLRServer.getConnection().createStatement();
        statement.execute(sqlServerManager.insertQuery("users", "(users_names)", "('%s')").formatted(users.getUsers_names()));
        statement.close();
    }

    public void deleteById(int id) throws SQLException {
        Statement statement = conectionManagerSQLRServer.getConnection().createStatement();
        statement.execute(sqlServerManager.deleteQuery("users", "user_id=%d".formatted(id)));
    }
}

