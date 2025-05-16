package service;

import entity.Users;
import repository.RepositorySQLServer;

import java.sql.SQLException;
import java.util.List;

public class ServiceServerSQL {
    private RepositorySQLServer repositorySQLServer;

    public ServiceServerSQL(RepositorySQLServer repositorySQLServer) {
        this.repositorySQLServer = repositorySQLServer;
    }

    public List<Users> findAll() throws SQLException {
        List<Users> all = repositorySQLServer.findAll();
        if (all.isEmpty()) {
            throw new RuntimeException("Пользователи не найдены");
        }
        return all;
    }

    public void insert(Users users) throws SQLException {
        repositorySQLServer.insert(users);
    }

    public void update(Users users) throws SQLException {
        repositorySQLServer.update(users);
    }

    public void deleteById(int id) throws SQLException {
        repositorySQLServer.deleteById(id);
    }
}
