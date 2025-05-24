package service.impl;

import entity.Employee;
import repository.impl.EmployeeRepositoryImpl;
import service.EmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepositoryImpl employeeRepositoryImpl;

    public EmployeeServiceImpl(EmployeeRepositoryImpl employeeRepositoryImpl) {
        this.employeeRepositoryImpl = employeeRepositoryImpl;
    }

    public List<Employee> findAll() throws SQLException {
        List<Employee> all = employeeRepositoryImpl.findAll();
        if (all.isEmpty()) {
            throw new RuntimeException("Вещи не найдены");
        }
        return all;
    }

    public void insert(Employee employee) throws SQLException {
        employeeRepositoryImpl.insert(employee);
    }

    public void deleteById(int id) throws SQLException {
        employeeRepositoryImpl.deleteById(id);
    }

    public void update(Employee employee) throws SQLException {
        employeeRepositoryImpl.update(employee);
    }
}

