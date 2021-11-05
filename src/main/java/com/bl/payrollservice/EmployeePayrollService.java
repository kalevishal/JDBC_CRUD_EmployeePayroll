package com.bl.payrollservice;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class EmployeePayrollService {
    EmployeeRepo employeeRepo = new EmployeeRepo();

    public static void main(String[] args) throws SQLException {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.getConnection();
        employeePayrollService.insertData();
        employeePayrollService.retrieveData();
    }

    private void retrieveData() throws SQLException {
        List<EmployeeInfo> employeeInfoList = employeeRepo.retrieveData();
        System.out.println(employeeInfoList);
    }


    private void getConnection() {
        EmployeeRepo.getConnection();
    }

    //    private void updateSalary() {
//        EmployeeRepo.updateSalary(3,3000);
//    }
//
    private void insertData() {
        EmployeeInfo employeeInfo= new EmployeeInfo();
        employeeInfo.setName("Trupti");
        employeeInfo.setGender('F');
        employeeInfo.setAddress("Solapur");
        employeeInfo.setPhone("547899999");
        employeeInfo.setStartDate(LocalDate.now());
        EmployeeRepo employeeRepo=new EmployeeRepo();
        employeeRepo.insertData(employeeInfo);
    }


}