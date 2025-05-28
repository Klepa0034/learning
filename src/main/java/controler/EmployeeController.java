package controler;

import entity.Employee;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> findAll() throws SQLException {
        return employeeService.findAll();
    }

    public void insert(Employee employee) throws SQLException {
        employeeService.insert(employee);
    }

    public void deleteById(int id) throws SQLException {
        employeeService.deleteById(id);
    }

    public void update(Employee employee) throws SQLException {
        employeeService.update(employee);
    }
}
