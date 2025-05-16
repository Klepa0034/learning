package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectionManagerMySQL {
    private String url = "jdbc:mysql://localhost:3306/items";
    private String password = "password";
    private String name = "root";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, name, password);
    }
}
