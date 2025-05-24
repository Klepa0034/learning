package manager.impl;

import manager.ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeConnectionManagerImpl implements ConnectionManager {
    //postgres
    private String url = "jdbc:postgresql://localhost:5432/item";
    private String password = "password";
    private String name = "name";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, name, password);
    }
}
