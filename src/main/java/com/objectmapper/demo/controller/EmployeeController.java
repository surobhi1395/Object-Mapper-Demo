package com.objectmapper.demo.controller;

import com.objectmapper.demo.model.Employee;
import com.objectmapper.demo.model.EmployeeData;
import com.objectmapper.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public Map<Integer, String> getAllEmpInfo(){

        return employeeService.getAllEmployee();
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeData> addEmployee(@RequestBody EmployeeData employeeData){
        EmployeeData employeeData1 = employeeService.addEmployee(employeeData);
        return ResponseEntity.ok().body(employeeData1);
    }
    }
