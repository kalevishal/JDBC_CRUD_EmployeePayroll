package com.bl.payrollservice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public void insertData(EmployeeInfo info) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "insert into employee(name,gender,startDate,phone,address) " +
                    "values ('" + info.getName() + "','" + info.getGender() + "'," +
                    "'" + info.getStartDate() + "','" + info.getPhone() + "'," +
                    "'" + info.getAddress() + "'); ";
            int result = statement.executeUpdate(sql);
            if (result == 1) {
                System.out.println("Query inserted");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public List<EmployeeInfo> retrieveData() {
        ResultSet resultSet = null;
        List<EmployeeInfo> employeeInfoList = new ArrayList<>(

        );
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "select * from employee";
            resultSet = statement.executeQuery(sql);
            int count = 1;
            while (resultSet.next()) {
                count++;
                EmployeeInfo employeeInfo = new EmployeeInfo();
                employeeInfo.setId(resultSet.getInt("id"));
                employeeInfo.setName(resultSet.getString("name"));
                employeeInfo.setGender(resultSet.getString("gender").charAt(0));
                employeeInfo.setStartDate(resultSet.getDate("startDate").toLocalDate());
                employeeInfoList.add(employeeInfo);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return employeeInfoList;


    }
}