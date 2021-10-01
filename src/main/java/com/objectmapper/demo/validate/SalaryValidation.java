package com.objectmapper.demo.validate;

import com.objectmapper.demo.model.EmployeeData;
import org.springframework.stereotype.Component;

@Component
public class SalaryValidation {

    public EmployeeData checkSalIncrement(EmployeeData employeeData){
        int increment = 0;
        if(employeeData.getEmployeeSalary()>300000
            && employeeData.getEmployeeSalary()<500000){
            increment = (int) (employeeData.getEmployeeSalary() +
                                (employeeData.getEmployeeSalary() * 0.5));
            employeeData.setEmployeeSalary(increment);
            return employeeData;
        }
        if(employeeData.getEmployeeSalary()>200000
            && employeeData.getEmployeeSalary()<300000){
            increment = (int) (employeeData.getEmployeeSalary() +
                    (employeeData.getEmployeeSalary()*0.2));
            employeeData.setEmployeeSalary(increment);
            return employeeData;
        }
        if(employeeData.getEmployeeSalary()>500000){
            increment = (int) (employeeData.getEmployeeSalary() +
                    (employeeData.getEmployeeSalary()*0.02));
            employeeData.setEmployeeSalary(increment);
            return employeeData;
        }
      return employeeData;
    }

}
