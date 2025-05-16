package controler;

import entity.Item;
import service.ServiceMySSQL;

import java.sql.SQLException;
import java.util.List;

public class ControlerMySQL {
    private ServiceMySSQL serviceMySSQL;

    public ControlerMySQL(ServiceMySSQL serviceMySSQL) {
        this.serviceMySSQL = serviceMySSQL;
    }

    public List<Item> findAll() throws SQLException {
        return serviceMySSQL.findAll();
    }

    public void insert(Item item) throws SQLException {
        serviceMySSQL.insert(item);
    }

    public void deleteById(int id) throws SQLException {
        serviceMySSQL.deleteById(id);
    }

    public void update(Item item) throws SQLException {
        serviceMySSQL.update(item);
    }
}
