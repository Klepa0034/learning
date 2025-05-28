package repository;

import entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll() throws SQLException;

    void insert(Employee employee) throws SQLException;

    void deleteById(int id) throws SQLException;

    void update(Employee employee) throws SQLException;
}
