package controler;

import entity.Item;
import service.ItemService;
import service.impl.ItemServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class ItemController {
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    public List<Item> findAll() throws SQLException {
        return itemService.findAll();
    }

    public void insert(Item item) throws SQLException {
        itemService.insert(item);
    }

    public void deleteById(int id) throws SQLException {
        itemService.deleteById(id);
    }

    public void update(Item item) throws SQLException {
        itemService.update(item);
    }
}
