package com.objectmapper.demo.service;

import com.objectmapper.demo.model.Employee;
import com.objectmapper.demo.model.EmployeeData;
import com.objectmapper.demo.startup.DataUtility;
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

    public Map<Integer, String> getAllEmployee(){
        Employee empDetails = dataUtility.getEmpDetails();
        // sorting by name
        empDetails.getData().sort(comparing(EmployeeData::getEmployeeSalary));
        List<EmployeeData> collect = empDetails.getData().stream()
                .filter(employeeData -> employeeData.employeeAge > 40)
                        .collect(Collectors.toList());
        Map<Integer, String> listToMap = collect.stream().collect(Collectors
                .toMap(EmployeeData::getId, EmployeeData::getEmployeeName));
        return listToMap;
    }

}
