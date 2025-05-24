package manager.impl;

import manager.ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserConnectionManagerImpl implements ConnectionManager {
    //hyeta
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=users;encrypt=true;trustServerCertificate=true;";
    private String password = "PASSword123";
    private String name = "SA";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, name, password);
    }

}
