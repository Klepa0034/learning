package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private String url = "jdbc:postgresql://localhost:5432/item";
    private String password = "password";
    private String name = "name";

    public Connection getConection() throws SQLException {
        return DriverManager.getConnection(url, name, password);
    }
}
