package result;

import entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ResultItem {
    public List<Item> resultToListItem(ResultSet resultSet) throws SQLException {
        List<Item> items = new LinkedList<>();
        while (resultSet.next()) {
            String name_item = resultSet.getString("name_items");
            long cost_item = resultSet.getLong("price_items");
            int id = resultSet.getInt("id");
            Item item = new Item(name_item, cost_item, id);
            items.add(item);

        }
        return items;
    }
}
