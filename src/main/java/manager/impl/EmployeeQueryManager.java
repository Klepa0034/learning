package manager.impl;

import manager.QueryManager;

public class EmployeeQueryManager implements QueryManager {
    public String getSelectAllQuery(String tableName) {
        return "SELECT * FROM %s".formatted(tableName);
    }

    public String updateQuery(String tableName, String params, String conditions) {
        return "UPDATE %s SET %s WHERE %s;".formatted(tableName, params, conditions);
    }

    public String deleteQuery(String tableName, String conditions) {
        return "DELETE FROM %s WHERE %s;".formatted(tableName, conditions);
    }

    public  String insertQuery(String tableName, String definitions, String values) {
        return "INSERT INTO %s %s VALUES %s;".formatted(tableName, definitions, values);
    }
}
