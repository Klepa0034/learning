package controler;

import entity.Employee;
import service.impl.EmployeeServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class EmployeeController {
    private EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    public List<Employee> findAll() throws SQLException {
        return employeeServiceImpl.findAll();
    }

    public void insert(Employee employee) throws SQLException {
        employeeServiceImpl.insert(employee);
    }

    public void deleteById(int id) throws SQLException {
        employeeServiceImpl.deleteById(id);
    }

    public void update(Employee employee) throws SQLException {
        employeeServiceImpl.update(employee);
    }
}
