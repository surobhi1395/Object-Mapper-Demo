package com.objectmapper.demo.service;

import com.objectmapper.demo.model.Datum;

import com.objectmapper.demo.model.User;
import com.objectmapper.demo.startup.DataUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private DataUtility dataUtility;

    public User getAllEmployee(){
        User run = dataUtility.run();

        return run;
    }

}
