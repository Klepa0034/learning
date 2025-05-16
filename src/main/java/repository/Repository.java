package repository;

import entity.Item;
import manager.ConectionManagerMySQL;
import result.ResultItem;
import sqlManager.SqlMyManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Repository {
    private ConectionManagerMySQL conectionManagerMySQL;
    private SqlMyManager sqlMyManager;
    private ResultItem resultItem;

    public Repository(ConectionManagerMySQL conectionManagerMySQL, SqlMyManager sqlMyManager, ResultItem resultItem) {
        this.conectionManagerMySQL = conectionManagerMySQL;
        this.sqlMyManager = sqlMyManager;
        this.resultItem = resultItem;
    }

    public List<Item> findAll() throws SQLException {
        Statement statement = conectionManagerMySQL.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlMyManager.getSelectAllQuery("items"));
        List<Item> items = resultItem.resultToListItem(resultSet);
        resultSet.close();
        statement.close();
        return items;

    }

    public void update(Item item) throws SQLException {
        Statement statement = conectionManagerMySQL.getConnection().createStatement();
        statement.executeUpdate(sqlMyManager.updateQuery("items", "name_items='%s',price_items=%d".formatted(item.getName_items(), item.getCost_items()), "id=%d".formatted(item.getId())));
    }

    public void insert(Item item) throws SQLException {
        Statement statement = conectionManagerMySQL.getConnection().createStatement();
        statement.execute(sqlMyManager.insertQuery("items", "(name_items,price_items)", "('%s',%d)").formatted(item.getName_items(), item.getCost_items()));
        statement.close();
    }

    public void deleteById(int id) throws SQLException {
        Statement statement = conectionManagerMySQL.getConnection().createStatement();
        statement.execute(sqlMyManager.deleteQuery("items", "id=%d".formatted(id)));
    }

}
