package com.example;

import controler.ItemController;
import controler.EmployeeController;
import controler.UserController;
import display.Display;
import manager.impl.ItemConnectionManagerImpl;
import manager.impl.UserConnectionManagerImpl;
import manager.impl.EmployeeConnectionManagerImpl;
import repository.impl.ItemRepositoryImpl;
import repository.impl.UserRepositoryImpl;
import repository.impl.EmployeeRepositoryImpl;
import result.impl.ItemResultImpl;
import result.impl.EmployeeResultImpl;
import result.impl.UserResultImpl;
import service.impl.EmployeeServiceImpl;
import service.impl.UserServiceImpl;
import service.impl.ItemServiceImpl;
import manager.impl.EmployeeManagerImpl;
import manager.impl.ItemManagerImpl;
import manager.impl.UserManagerImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        //обычная sql
        ItemResultImpl itemResultImpl = new ItemResultImpl();
        ItemConnectionManagerImpl itemConnectionManagerImpl = new ItemConnectionManagerImpl();
        ItemManagerImpl itemManagerImpl = new ItemManagerImpl();
        ItemRepositoryImpl itemRepositoryImpl = new ItemRepositoryImpl(itemConnectionManagerImpl, itemManagerImpl, itemResultImpl);
        ItemServiceImpl itemServiceImpl = new ItemServiceImpl(itemRepositoryImpl);
        ItemController itemController = new ItemController(itemServiceImpl);
        //
        UserResultImpl userResultImpl = new UserResultImpl();
        UserConnectionManagerImpl userConnectionManagerImpl = new UserConnectionManagerImpl();
        UserManagerImpl userManagerImpl = new UserManagerImpl();
        UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl(userConnectionManagerImpl, userManagerImpl, userResultImpl);
        UserServiceImpl userServiceImpl = new UserServiceImpl(userRepositoryImpl);
        UserController userController = new UserController(userServiceImpl);
        //postgres
        EmployeeResultImpl employeeResultImpl = new EmployeeResultImpl();
        EmployeeConnectionManagerImpl employeeConnectionManagerImpl = new EmployeeConnectionManagerImpl();
        EmployeeManagerImpl employeeManagerImpl = new EmployeeManagerImpl();
        EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl(employeeConnectionManagerImpl, employeeManagerImpl, employeeResultImpl);
        EmployeeServiceImpl employeeServiceImpl =new EmployeeServiceImpl(employeeRepositoryImpl);
        EmployeeController employeeController = new EmployeeController(employeeServiceImpl);

        Display display = new Display(itemController, userController, employeeController);
        display.start();
    }
}
