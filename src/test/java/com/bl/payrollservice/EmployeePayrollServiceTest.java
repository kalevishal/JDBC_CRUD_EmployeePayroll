package com.bl.payrollservice;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class EmployeePayrollServiceTest {
    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount(){
        EmployeePayrollService employeePayrollService=new EmployeePayrollService();
        List<EmployeeInfo> employeeInfo =employeePayrollService.employeeRepo.retrieveData();
        Assert.assertEquals(7, employeeInfo.size());
    }
}