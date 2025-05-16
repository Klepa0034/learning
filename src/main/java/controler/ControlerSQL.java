package controler;

import entity.Item;
import entity.ItemSql;
import service.ServiceMySSQL;
import service.ServiceSql;

import java.sql.SQLException;
import java.util.List;

public class ControlerSQL {
    private ServiceSql serviceSql;

    public ControlerSQL(ServiceSql serviceSql) {
        this.serviceSql = serviceSql;
    }

    public List<ItemSql> findAll() throws SQLException {
        return serviceSql.findAll();
    }

    public void insert(ItemSql itemSql) throws SQLException {
        serviceSql.insert(itemSql);
    }

    public void deleteById(int id) throws SQLException {
        serviceSql.deleteById(id);
    }

    public void update(ItemSql itemSql) throws SQLException {
        serviceSql.update(itemSql);
    }
}
