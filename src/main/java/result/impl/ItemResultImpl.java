package result.impl;

import entity.Item;
import result.ItemResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ItemResultImpl implements ItemResult {
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
