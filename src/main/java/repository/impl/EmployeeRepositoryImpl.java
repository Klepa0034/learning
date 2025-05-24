package repository.impl;
import entity.Employee;
import manager.impl.EmployeeConnectionManagerImpl;
import repository.EmployeeRepository;
import result.impl.EmployeeResultImpl;
import manager.impl.EmployeeManagerImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    //postgres
    private EmployeeConnectionManagerImpl employeeConnectionManagerImpl;
    private EmployeeManagerImpl employeeManagerImpl;
    private EmployeeResultImpl employeeResultImpl;

    public EmployeeRepositoryImpl(EmployeeConnectionManagerImpl employeeConnectionManagerImpl, EmployeeManagerImpl employeeManagerImpl, EmployeeResultImpl employeeResultImpl) {
        this.employeeConnectionManagerImpl = employeeConnectionManagerImpl;
        this.employeeManagerImpl = employeeManagerImpl;
        this.employeeResultImpl = employeeResultImpl;
    }

    public List<Employee> findAll() throws SQLException  {
       Statement statement = employeeConnectionManagerImpl.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(employeeManagerImpl.getSelectAllQuery("employees"));
        List<Employee> employees = employeeResultImpl.resultToListEmployee(resultSet);
        resultSet.close();
        statement.close();
        return employees;

    }

    public void update(Employee employee) throws SQLException {
        Statement statement = employeeConnectionManagerImpl.getConnection().createStatement();
        statement.executeUpdate(employeeManagerImpl.updateQuery("employees", "name='%s',salary=%d".formatted(employee.getName(), employee.getSalary()), "id=%d".formatted(employee.getId())));
    }

    public void insert(Employee employee) throws SQLException {
        Statement statement = employeeConnectionManagerImpl.getConnection().createStatement();
        statement.execute(EmployeeManagerImpl.insertQuery("employees", "(name,salary)", "('%s',%d)").formatted(employee.getName(), employee.getSalary()));
        statement.close();
    }

    public void deleteById(int id) throws SQLException {
        Statement statement = employeeConnectionManagerImpl.getConnection().createStatement();
        statement.execute(employeeManagerImpl.deleteQuery("employees", "id_item=%d".formatted(id)));
    }
}
