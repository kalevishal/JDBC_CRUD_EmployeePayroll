package com.bl.payrollservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeRepo {
    static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String username = "root";
        String password = "Monali@12345";
        Connection connection = null;
        try {
            //Loading and registering driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return connection;
    }
}