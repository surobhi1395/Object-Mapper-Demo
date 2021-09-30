package com.objectmapper.demo.validate;

import com.objectmapper.demo.model.EmployeeData;
import org.springframework.stereotype.Component;

@Component
public class SalaryValidation {

    public void checkSalIncrement(EmployeeData employeeData){
        int increment = 0;
        if(employeeData.getEmployeeSalary()>300000){
            increment = (int) (employeeData.getEmployeeSalary() +
                                (employeeData.getEmployeeSalary() * 0.5));
            employeeData.setEmployeeSalary(increment);
        }
        if(employeeData.getEmployeeSalary()>200000){
            increment = (int) (employeeData.getEmployeeSalary() +
                    (employeeData.getEmployeeSalary()*0.2));
            employeeData.setEmployeeSalary(increment);
        }
        if(employeeData.getEmployeeSalary()>500000){
            increment = (int) (employeeData.getEmployeeSalary() +
                    (employeeData.getEmployeeSalary()*0.02));
            employeeData.setEmployeeSalary(increment);
        }

    }

}
