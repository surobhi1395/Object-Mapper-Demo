package com.objectmapper.demo.validate;

import com.objectmapper.demo.constant.EmployeeConstant;
import com.objectmapper.demo.customException.EmployeeNotFoundException;
import com.objectmapper.demo.model.EmployeeData;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidation {

    public void validateEmployeeName(EmployeeData employeeData){

        int idLength = String.valueOf(employeeData.getId()).length();
        if (idLength > 10){
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
