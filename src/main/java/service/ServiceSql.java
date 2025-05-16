package service;

import entity.Item;
import entity.ItemSql;
import repository.Repository;
import repository.RepositorySql;

import java.sql.SQLException;
import java.util.List;

public class ServiceSql {
    private RepositorySql repositorySql;

    public ServiceSql(RepositorySql repositorySql) {
        this.repositorySql = repositorySql;
    }

    public List<ItemSql> findAll() throws SQLException {
        List<ItemSql> all = repositorySql.findAll();
        if (all.isEmpty()) {
            throw new RuntimeException("Вещи не найдены");
        }
        return all;
    }

    public void insert(ItemSql itemSql) throws SQLException {
        repositorySql.insert(itemSql);
    }

    public void deleteById(int id) throws SQLException {
        repositorySql.deleteById(id);
    }

    public void update(ItemSql itemSql) throws SQLException {
        repositorySql.update(itemSql);
    }
}
