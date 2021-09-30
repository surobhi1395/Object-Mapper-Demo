package com.objectmapper.demo.service;

import com.objectmapper.demo.constant.EmployeeConstant;
import com.objectmapper.demo.model.Employee;
import com.objectmapper.demo.model.EmployeeData;
import com.objectmapper.demo.startup.DataUtility;
import com.objectmapper.demo.validate.EmployeeValidation;
import com.objectmapper.demo.validate.SalaryValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Service
public class EmployeeService {

    @Autowired
    private DataUtility dataUtility;

    @Autowired
    private EmployeeValidation employeeValidation;

    @Autowired
    private SalaryValidation salaryValidation;

    public Map<Integer, String> getAllEmployee(){

        Employee empDetails = dataUtility.getEmpDetails();
        // sorting by name
        empDetails.getData().sort(comparing(EmployeeData::getEmployeeSalary));
        List<EmployeeData> collect = empDetails.getData().stream()
                .filter(employeeData -> employeeData.employeeAge > EmployeeConstant.Constants.AGE)
                        .collect(Collectors.toList());

        // just for checking
        return collect.stream().collect(Collectors
                .toMap(EmployeeData::getId, EmployeeData::getEmployeeName));

    }

    public EmployeeData addEmployee(EmployeeData employeeData) {

            employeeValidation.validateEmployeeName(employeeData);
            salaryValidation.checkSalIncrement(employeeData);
            employeeData.getId();
            employeeData.getEmployeeName();
            employeeData.getEmployeeSalary();
            employeeData.getEmployeeAge();
            employeeData.getProfileImage();

        return employeeData;
    }
}
