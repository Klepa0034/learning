package result.impl;

import entity.User;
import result.UserResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserResultImpl implements UserResult {
    public List<User> resultToListUsers(ResultSet resultSet) throws SQLException {
        List<User> users = new LinkedList<>();
        while (resultSet.next()) {
            String users_names = resultSet.getString("users_names");
            int id = resultSet.getInt("user_id");
            User user1 = new User(users_names, id);
            users.add(user1);

        }
        return users;
    }
}
