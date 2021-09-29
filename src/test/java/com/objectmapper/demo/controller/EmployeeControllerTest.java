package com.objectmapper.demo.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.objectmapper.demo.model.EmployeeData;
import com.objectmapper.demo.model.Employee;
import com.objectmapper.demo.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {EmployeeController.class})
@ExtendWith(SpringExtension.class)
class EmployeeControllerTest {
    @Autowired
    private EmployeeController employeeController;

    @MockBean
    private EmployeeService employeeService;

    @Test
    void testAddEmployee() throws Exception {
        when(this.employeeService.addEmployee((EmployeeData) any())).thenReturn(new EmployeeData());

        EmployeeData employeeData = new EmployeeData();
        employeeData.setEmployeeSalary(1);
        employeeData.setId(1);
        employeeData.setProfileImage("Profile Image");
        employeeData.setEmployeeAge(1);
        employeeData.setEmployeeName("Employee Name");
        String content = (new ObjectMapper()).writeValueAsString(employeeData);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/createEmployee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }

    @Test
    void testGetAllEmpInfo() throws Exception {
        Employee user = new Employee();
        user.setMessage("Not all who wander are lost");
        user.setStatus("Status");
        user.setData(new ArrayList<EmployeeData>());
        when(this.employeeService.getAllEmployee()).thenReturn((Map<Integer, String>) user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee");
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"status\":\"Status\",\"data\":[],\"message\":\"Not all who wander are lost\"}"));
    }
}

