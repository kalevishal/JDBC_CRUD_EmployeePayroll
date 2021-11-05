package com.bl.payrollservice;

import java.time.LocalDate;

public class EmployeePayrollService {
    public static void main(String[] args) {
        EmployeePayrollService employeePayrollService=new EmployeePayrollService();
        employeePayrollService.getConnection();
    }

    private void getConnection() {
        EmployeeRepo.getConnection();
    }

}