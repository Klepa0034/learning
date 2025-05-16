package com.example;

import controler.ControlerMySQL;
import controler.ControlerSQL;
import controler.ControlerServerSQL;
import display.Display;
import manager.ConectionManagerMySQL;
import manager.ConectionManagerSQLRServer;
import manager.ConnectionManager;
import repository.Repository;
import repository.RepositorySQLServer;
import repository.RepositorySql;
import result.ResultItem;
import result.ResultItemP;
import result.ResultUsers;
import service.ServiceMySSQL;
import service.ServiceServerSQL;
import service.ServiceSql;
import sqlManager.SqlManager;
import sqlManager.SqlMyManager;
import sqlManager.SqlServerManager;

import java.sql.SQLException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws SQLException {
        ResultItem resultItem = new ResultItem();
        ConectionManagerMySQL conectionManagerMySQL = new ConectionManagerMySQL();
        SqlMyManager sqlMyManager = new SqlMyManager();
        Repository repository = new Repository(conectionManagerMySQL, sqlMyManager, resultItem);
        ServiceMySSQL serviceMySSQL = new ServiceMySSQL(repository);
        ControlerMySQL controlerMySQL = new ControlerMySQL(serviceMySSQL);

        ResultUsers resultUsers = new ResultUsers();
        ConectionManagerSQLRServer conectionManagerSQLRServer = new ConectionManagerSQLRServer();
        SqlServerManager sqlServerManager = new SqlServerManager();
        RepositorySQLServer repositorySQLServer = new RepositorySQLServer(conectionManagerSQLRServer, sqlServerManager, resultUsers);
        ServiceServerSQL serviceServerSQL = new ServiceServerSQL(repositorySQLServer);
        ControlerServerSQL controlerServerSQL = new ControlerServerSQL(serviceServerSQL);

        ResultItemP resultItemP = new ResultItemP();
        ConnectionManager connectionManager = new ConnectionManager();
        SqlManager sqlManager = new SqlManager();
        RepositorySql repositorySql = new RepositorySql(connectionManager,sqlManager,resultItemP);
        ServiceSql serviceSql =new ServiceSql(repositorySql);
        ControlerSQL controlerSQL = new ControlerSQL(serviceSql);

        Display display = new Display(controlerMySQL, controlerServerSQL,controlerSQL);
        display.start();
    }
}
