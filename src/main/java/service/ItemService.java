package service;

import entity.Employee;
import entity.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemService {
    List<Item> findAll() throws SQLException;

    void insert(Item item) throws SQLException;

    void deleteById(int id) throws SQLException;

    void update(Item item) throws SQLException;
}
