package manager;

public interface ConnectionManagerSQL {
    public String getSelectAllQuery(String tableName);
    public String updateQuery(String tableName, String params, String conditions);
    public String deleteQuery(String tableName, String conditions);

    public static String insertQuery(String tableName, String definitions, String values) {
        return null;
    }
}
