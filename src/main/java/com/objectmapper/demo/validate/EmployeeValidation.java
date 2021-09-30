package com.objectmapper.demo.validate;

import com.objectmapper.demo.constant.EmployeeConstant;
import com.objectmapper.demo.customException.EmployeeNotFoundException;
import com.objectmapper.demo.model.EmployeeData;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidation {

    public void validateEmployeeName(EmployeeData employeeData){

      /* if(employeeData.getId()>EmployeeConstant.Constants.LIMIT
               && employeeData.getEmployeeName().length()> EmployeeConstant.Constants.CHARACTERS
               && employeeData.getEmployeeName().matches("^[a-zA-Z]*$")
               && employeeData.getEmployeeAge()<EmployeeConstant.Constants.AGE){

           throw new EmployeeNotFoundException("Not a Valid Info");

       } */
        if (String.valueOf(employeeData.getId()).length() >= 10){
            throw new EmployeeNotFoundException("Not a Valid Info");
        }
        if(employeeData.getEmployeeName().length()>32
            && employeeData.getEmployeeName().matches("^[a-zA-Z]*$")){
            throw new EmployeeNotFoundException("Not a Valid Info");
        }
        if(employeeData.getEmployeeAge() < 40){
            throw new EmployeeNotFoundException("Not a Valid Info");
        }
    }

}
