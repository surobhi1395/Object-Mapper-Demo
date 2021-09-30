package com.objectmapper.demo.validate;

import com.objectmapper.demo.customException.EmployeeNotFoundException;
import com.objectmapper.demo.model.EmployeeData;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidation {

    public void validateEmployeeName(EmployeeData employeeData){

        if (String.valueOf(employeeData.getId()).length() > 10){
            throw new EmployeeNotFoundException("Not a Valid Employee Id");
        }
        if(employeeData.getEmployeeName().length()>32
            && employeeData.getEmployeeName().matches("^[a-zA-Z]*$")){
            throw new EmployeeNotFoundException("Not a Valid Employee Name");
        }
        if(employeeData.getEmployeeAge() < 40){
            throw new EmployeeNotFoundException("Not a Valid Employee Age");
        }
    }

}
