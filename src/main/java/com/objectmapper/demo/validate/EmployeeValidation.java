package com.objectmapper.demo.validate;

import com.objectmapper.demo.constant.EmployeeConstant;
import com.objectmapper.demo.exception.EmployeeNotFoundException;
import com.objectmapper.demo.model.EmployeeData;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidation {

    public EmployeeData validateEmployeeName(EmployeeData employeeData){

       if(employeeData.getId()>EmployeeConstant.Constants.LIMIT
               && employeeData.getEmployeeName().length()> EmployeeConstant.Constants.CHARACTERS
               && employeeData.getEmployeeName().matches("^[a-zA-Z]*$")
               && employeeData.getEmployeeAge()<EmployeeConstant.Constants.AGE){

           throw new EmployeeNotFoundException("Not a Valid Info");

       }

       return employeeData;
    }

}
