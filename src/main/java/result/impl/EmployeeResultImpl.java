package result.impl;

import entity.Employee;
import result.EmployeeResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public  class EmployeeResultImpl implements EmployeeResult {
    public List<Employee> resultToListEmployee(ResultSet resultSet) throws SQLException {
        List<Employee> items = new LinkedList<>();
        while (resultSet.next()) {
            String name_item = resultSet.getString("name");
            long price_item = resultSet.getLong("salary");
            int id = resultSet.getInt("id");
            Employee item = new Employee(name_item, price_item, id);
            items.add(item);

        }
        return items;
    }
}
