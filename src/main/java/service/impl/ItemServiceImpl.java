package service.impl;

import entity.Item;
import repository.impl.ItemRepositoryImpl;
import service.ItemService;

import java.sql.SQLException;
import java.util.List;

public class ItemServiceImpl implements ItemService {
    private ItemRepositoryImpl itemRepositoryImpl;

    public ItemServiceImpl(ItemRepositoryImpl itemRepositoryImpl) {
        this.itemRepositoryImpl = itemRepositoryImpl;
    }


    public List<Item> findAll() throws SQLException {
        List<Item> all = itemRepositoryImpl.findAll();
        if (all.isEmpty()) {
            throw new RuntimeException("Вещи не найдены");
        }
        return all;
    }

    public void insert(Item item) throws SQLException {
        itemRepositoryImpl.insert(item);
    }

    public void deleteById(int id) throws SQLException {
        itemRepositoryImpl.deleteById(id);
    }

    public void update(Item item) throws SQLException {
        itemRepositoryImpl.update(item);
    }
}
