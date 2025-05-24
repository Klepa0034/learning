package controler;

import entity.Item;
import service.impl.ItemServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class ItemController {
    private ItemServiceImpl itemServiceImpl;

    public ItemController(ItemServiceImpl itemServiceImpl) {
        this.itemServiceImpl = itemServiceImpl;
    }

    public List<Item> findAll() throws SQLException {
        return itemServiceImpl.findAll();
    }

    public void insert(Item item) throws SQLException {
        itemServiceImpl.insert(item);
    }

    public void deleteById(int id) throws SQLException {
        itemServiceImpl.deleteById(id);
    }

    public void update(Item item) throws SQLException {
        itemServiceImpl.update(item);
    }
}
