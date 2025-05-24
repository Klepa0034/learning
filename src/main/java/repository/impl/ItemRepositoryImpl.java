package repository.impl;

import entity.Item;
import manager.impl.ItemConnectionManagerImpl;
import repository.ItemRepository;
import result.impl.ItemResultImpl;
import manager.impl.ItemManagerImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ItemRepositoryImpl implements ItemRepository {
    //mysql
    private ItemConnectionManagerImpl itemConnectionManagerImpl;
    private ItemManagerImpl itemManagerImpl;
    private ItemResultImpl itemResultImpl;

    public ItemRepositoryImpl(ItemConnectionManagerImpl itemConnectionManagerImpl, ItemManagerImpl itemManagerImpl, ItemResultImpl itemResultImpl) {
        this.itemConnectionManagerImpl = itemConnectionManagerImpl;
        this.itemManagerImpl = itemManagerImpl;
        this.itemResultImpl = itemResultImpl;
    }

    public List<Item> findAll() throws SQLException {
        Statement statement = itemConnectionManagerImpl.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(itemManagerImpl.getSelectAllQuery("items"));
        List<Item> items = itemResultImpl.resultToListItem(resultSet);
        resultSet.close();
        statement.close();
        return items;

    }

    public void update(Item item) throws SQLException {
        Statement statement = itemConnectionManagerImpl.getConnection().createStatement();
        statement.executeUpdate(itemManagerImpl.updateQuery("items", "name_items='%s',price_items=%d".formatted(item.getName_items(), item.getCost_items()), "id=%d".formatted(item.getId())));
    }

    public void insert(Item item) throws SQLException {
        Statement statement = itemConnectionManagerImpl.getConnection().createStatement();
        statement.execute(itemManagerImpl.insertQuery("items", "(name_items,price_items)", "('%s',%d)").formatted(item.getName_items(), item.getCost_items()));
        statement.close();
    }

    public void deleteById(int id) throws SQLException {
        Statement statement = itemConnectionManagerImpl.getConnection().createStatement();
        statement.execute(itemManagerImpl.deleteQuery("items", "id=%d".formatted(id)));
    }

}
