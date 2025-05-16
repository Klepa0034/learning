package result;

import entity.Item;
import entity.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ResultUsers {
    public List<Users> resultToListUsers(ResultSet resultSet) throws SQLException {
        List<Users> users = new LinkedList<>();
        while (resultSet.next()) {
            String users_names = resultSet.getString("users_names");
            int id = resultSet.getInt("user_id");
            Users users1 = new Users(users_names, id);
            users.add(users1);

        }
        return users;
    }
}
