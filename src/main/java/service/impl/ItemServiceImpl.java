package service.impl;

import entity.Item;
import repository.ItemRepository;
import repository.impl.ItemRepositoryImpl;
import service.ItemService;

import java.sql.SQLException;
import java.util.List;

public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    public List<Item> findAll() throws SQLException {
        List<Item> all = itemRepository.findAll();
        if (all.isEmpty()) {
            throw new RuntimeException("Вещи не найдены");
        }
        return all;
    }

    public void insert(Item item) throws SQLException {
        itemRepository.insert(item);
    }

    public void deleteById(int id) throws SQLException {
        itemRepository.deleteById(id);
    }

    public void update(Item item) throws SQLException {
        itemRepository.update(item);
    }
}
