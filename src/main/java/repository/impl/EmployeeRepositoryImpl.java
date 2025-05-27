package repository.impl;
import entity.Employee;
import manager.ConnectionManager;
import manager.QueryManager;
import repository.EmployeeRepository;
import result.EmployeeResult;
import result.impl.EmployeeResultImpl;
import manager.impl.EmployeeManagerImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    //postgres EmployeeConnectionManagerImpl
    private QueryManager queryManager;
    private EmployeeResult employeeResult;
    private ConnectionManager connectionManager;


    public EmployeeRepositoryImpl(QueryManager queryManager, EmployeeResult employeeResult, ConnectionManager connectionManager) {
        this.queryManager = queryManager;
        this.employeeResult = employeeResult;
        this.connectionManager = connectionManager;
    }

    public List<Employee> findAll() throws SQLException  {
       Statement statement = connectionManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(queryManager.getSelectAllQuery("employees"));
        List<Employee> employees = employeeResult.resultToListEmployee(resultSet);
        resultSet.close();
        statement.close();
        return employees;

    }

    public void update(Employee employee) throws SQLException {
        Statement statement = connectionManager.getConnection().createStatement();
        statement.executeUpdate(queryManager.updateQuery("employees", "name='%s',salary=%d".formatted(employee.getName(), employee.getSalary()), "id=%d".formatted(employee.getId())));
    }

    public void insert(Employee employee) throws SQLException {
        Statement statement = connectionManager.getConnection().createStatement();
        statement.execute(queryManager.insertQuery("employees", "(name,salary)", "('%s',%d)").formatted(employee.getName(), employee.getSalary()));
        statement.close();
    }

    public void deleteById(int id) throws SQLException {
        Statement statement = connectionManager.getConnection().createStatement();
        statement.execute(queryManager.deleteQuery("employees", "id_item=%d".formatted(id)));
    }
}
