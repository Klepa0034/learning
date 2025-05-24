package result;

import entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeResult {
    public List<Employee> resultToListEmployee(ResultSet resultSet) throws SQLException;

}
