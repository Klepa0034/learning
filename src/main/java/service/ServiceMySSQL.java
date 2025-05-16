package service;

import entity.Item;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class ServiceMySSQL {
    private Repository repository;

    public ServiceMySSQL(Repository repository) {
        this.repository = repository;
    }

    public List<Item> findAll() throws SQLException {
        List<Item> all = repository.findAll();
        if (all.isEmpty()) {
            throw new RuntimeException("Вещи не найдены");
        }
        return all;
    }

    public void insert(Item item) throws SQLException {
        repository.insert(item);
    }

    public void deleteById(int id) throws SQLException {
        repository.deleteById(id);
    }

    public void update(Item item) throws SQLException {
        repository.update(item);
    }
}
