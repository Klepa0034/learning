package result;

import entity.ItemSql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ResultItemP {
    public List<ItemSql> resultToListItemP(ResultSet resultSet) throws SQLException {
        List<ItemSql> items = new LinkedList<>();
        while (resultSet.next()) {
            String name_item = resultSet.getString("name_item");
            long price_item = resultSet.getLong("price_item");
            int id = resultSet.getInt("id_item");
            ItemSql item = new ItemSql(name_item, price_item, id);
            items.add(item);

        }
        return items;
    }
}
