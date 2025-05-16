package repository;
import entity.ItemSql;
import manager.ConnectionManager;
import result.ResultItemP;
import sqlManager.SqlManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class RepositorySql {
    private ConnectionManager connectionManager;
    private SqlManager sqlManager;
    private ResultItemP resultItemP;

    public RepositorySql(ConnectionManager connectionManager, SqlManager sqlManager, ResultItemP resultItemP) {
        this.connectionManager = connectionManager;
        this.sqlManager = sqlManager;
        this.resultItemP = resultItemP;
    }

    public List<ItemSql> findAll() throws SQLException {
       Statement statement = connectionManager.getConection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlManager.getSelectAllQuery("item"));
        List<ItemSql> items = resultItemP.resultToListItemP(resultSet);
        resultSet.close();
        statement.close();
        return items;

    }

    public void update(ItemSql itemSql) throws SQLException {
        Statement statement = connectionManager.getConection().createStatement();
        statement.executeUpdate(sqlManager.updateQuery("item", "name_item='%s',price_item=%d".formatted(itemSql.getName_item(), itemSql.getPrice_item()), "id_item=%d".formatted(itemSql.getId())));
    }

    public void insert(ItemSql itemSql) throws SQLException {
        Statement statement = connectionManager.getConection().createStatement();
        statement.execute(SqlManager.insertQuery("item", "(name_item,price_item)", "('%s',%d)").formatted(itemSql.getName_item(), itemSql.getPrice_item()));
        statement.close();
    }

    public void deleteById(int id) throws SQLException {
        Statement statement = connectionManager.getConection().createStatement();
        statement.execute(sqlManager.deleteQuery("item", "id_item=%d".formatted(id)));
    }
}
