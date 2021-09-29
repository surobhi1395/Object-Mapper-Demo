package com.objectmapper.demo.validate;

import com.objectmapper.demo.constant.EmployeeConstant;
import com.objectmapper.demo.exception.BadRequestException;
import com.objectmapper.demo.model.EmployeeData;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidation {

    public void validateEmployeeName(EmployeeData employeeData){

       if(employeeData.getId()!=EmployeeConstant.Constants.LIMIT){
           throw new BadRequestException("400", "Bad Request");
       }
       if(employeeData.getEmployeeName().length()> EmployeeConstant.Constants.CHARACTERS
               && employeeData.getEmployeeName().matches("^[a-zA-Z]*$")){
           throw new BadRequestException("400", "Bad Request");
       }
       if(employeeData.getEmployeeAge()<EmployeeConstant.Constants.AGE){
           throw new BadRequestException("400", "Bad Request");
       }
    }

}
