package result;

import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UserResult {
     List<User> resultToListUsers(ResultSet resultSet) throws SQLException;

}
