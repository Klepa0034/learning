package repository.impl;

import entity.Item;
import manager.ConnectionManager;
import manager.QueryManager;
import repository.ItemRepository;
import result.impl.ItemResultImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ItemRepositoryImpl implements ItemRepository {
    //mysql
    private QueryManager queryManager;
    private ConnectionManager connectionManager;
    private ItemResultImpl itemResultImpl;

    public ItemRepositoryImpl(ConnectionManager connectionManager, QueryManager queryManager, ItemResultImpl itemResultImpl) {
        this.queryManager = queryManager;
        this.connectionManager = connectionManager;
        this.itemResultImpl = itemResultImpl;
    }

    public List<Item> findAll() throws SQLException {
        Statement statement = connectionManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(queryManager.getSelectAllQuery("items"));
        List<Item> items = itemResultImpl.resultToListItem(resultSet);
        resultSet.close();
        statement.close();
        return items;

    }

    public void update(Item item) throws SQLException {
        Statement statement = connectionManager.getConnection().createStatement();
        statement.executeUpdate(queryManager.updateQuery("items", "name_items='%s',price_items=%d".formatted(item.getNameItems(), item.getCostItems()), "id=%d".formatted(item.getId())));
    }

    public void insert(Item item) throws SQLException {
        Statement statement = connectionManager.getConnection().createStatement();
        statement.execute(queryManager.insertQuery("items", "(name_items,price_items)", "('%s',%d)").formatted(item.getNameItems(), item.getCostItems()));
        statement.close();
    }

    public void deleteById(int id) throws SQLException {
        Statement statement = connectionManager.getConnection().createStatement();
        statement.execute(queryManager.deleteQuery("items", "id=%d".formatted(id)));
    }

}
