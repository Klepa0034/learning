package controler;

import entity.Item;
import entity.Users;
import repository.Repository;
import repository.RepositorySQLServer;
import service.ServiceMySSQL;
import service.ServiceServerSQL;

import java.sql.SQLException;
import java.util.List;

public class ControlerServerSQL {
    private ServiceServerSQL serviceServerSQL;

    public ControlerServerSQL(ServiceServerSQL serviceServerSQL) {
        this.serviceServerSQL = serviceServerSQL;
    }

    public List<Users> findAll() throws SQLException {
        return serviceServerSQL.findAll();
    }

    public void insert(Users users) throws SQLException {
        serviceServerSQL.insert(users);
    }

    public void update(Users users) throws SQLException {
        serviceServerSQL.update(users);
    }

    public void deleteById(int id) throws SQLException {
        serviceServerSQL.deleteById(id);
    }

}
