package manager;

public interface QueryManager {
     String getSelectAllQuery(String tableName);
     String updateQuery(String tableName, String params, String conditions);
     String deleteQuery(String tableName, String conditions);

     String insertQuery(String tableName, String definitions, String values);


}
