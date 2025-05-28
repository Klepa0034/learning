package com.example;

import controler.ItemController;
import controler.EmployeeController;
import controler.UserController;
import display.Display;
import manager.ConnectionManager;
import manager.QueryManager;
import manager.impl.UserQueryManager;
import manager.impl.ItemConnectionManager;
import manager.impl.UserConnectionManager;
import manager.impl.EmployeeConnectionManager;
import repository.impl.ItemRepositoryImpl;
import repository.impl.UserRepositoryImpl;
import result.EmployeeResult;
import result.impl.EmployeeResultImpl;
import result.impl.ItemResultImpl;
import result.impl.UserResultImpl;
import service.impl.EmployeeServiceImpl;
import service.impl.UserServiceImpl;
import service.impl.ItemServiceImpl;
import manager.impl.EmployeeQueryManager;
import manager.impl.ItemQueryManager;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        //обычная sql
        ItemResultImpl itemResultImpl = new ItemResultImpl();
        ItemConnectionManager itemConnectionManager = new ItemConnectionManager();
        ItemQueryManager itemQueryManager = new ItemQueryManager();
        ItemRepositoryImpl itemRepositoryImpl = new ItemRepositoryImpl(itemConnectionManager, itemQueryManager, itemResultImpl);
        ItemServiceImpl itemServiceImpl = new ItemServiceImpl(itemRepositoryImpl);
        ItemController itemController = new ItemController(itemServiceImpl);
        //
        UserResultImpl userResultImpl = new UserResultImpl();
        UserConnectionManager userConnectionManager = new UserConnectionManager();
        QueryManager userManager = new UserQueryManager();
        UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl(userConnectionManager, userManager, userResultImpl);
        UserServiceImpl userServiceImpl = new UserServiceImpl(userRepositoryImpl);
        UserController userController = new UserController(userServiceImpl);
        //postgres
        ConnectionManager connectionManager = new EmployeeConnectionManager();
        QueryManager queryManager = new EmployeeQueryManager();
        EmployeeResult employeeResult = new EmployeeResultImpl();
        repository.impl.EmployeeRepositoryImpl employeeRepositoryImpl = new repository.impl.EmployeeRepositoryImpl(queryManager,employeeResult,connectionManager);
        EmployeeServiceImpl employeeServiceImpl =new EmployeeServiceImpl(employeeRepositoryImpl);
        EmployeeController employeeController = new EmployeeController(employeeServiceImpl);

        Display display = new Display(itemController, userController, employeeController);
        display.start();
    }
}
