package result;

import entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ItemResult {
     List<Item> resultToListItem(ResultSet resultSet) throws SQLException;
}
