package com.example.homebudget.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/home_budget?characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
        String userName = "root";
        String password = "***";

        return DriverManager.getConnection(url, userName, password);
    }

}
