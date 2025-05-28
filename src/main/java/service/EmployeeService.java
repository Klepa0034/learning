package service;

import entity.Employee;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
    List<Employee> findAll() throws SQLException;

    void insert(Employee employee) throws SQLException;

    void deleteById(int id) throws SQLException;

    void update(Employee employee) throws SQLException;
}
