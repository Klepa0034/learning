package service.impl;

import entity.Employee;
import repository.EmployeeRepository;
import repository.impl.EmployeeRepositoryImpl;
import service.EmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() throws SQLException {
        List<Employee> all = employeeRepository.findAll();
        if (all.isEmpty()) {
            throw new RuntimeException("Вещи не найдены");
        }
        return all;
    }

    public void insert(Employee employee) throws SQLException {
        employeeRepository.insert(employee);
    }

    public void deleteById(int id) throws SQLException {
        employeeRepository.deleteById(id);
    }

    public void update(Employee employee) throws SQLException {
        employeeRepository.update(employee);
    }
}

