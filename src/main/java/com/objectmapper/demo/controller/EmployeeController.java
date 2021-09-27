package com.objectmapper.demo.controller;

import com.objectmapper.demo.model.Datum;
import com.objectmapper.demo.model.User;
import com.objectmapper.demo.service.EmployeeService;
import org.apache.catalina.mbeans.DataSourceUserDatabaseMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public User getAllEmpInfo(){
        return employeeService.getAllEmployee();
    }

}
