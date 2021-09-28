package com.objectmapper.demo.startup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.objectmapper.demo.model.EmployeeData;

import com.objectmapper.demo.model.Employee;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.io.File;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.groupingBy;

@Component
@Log
public class DataUtility {

    public static final String SRC_MAIN_RESOURCES_DATUM_JSON = "src/main/resources/datum.json";
    private EmployeeData datum;

    @SneakyThrows // find the use of sneaky throws
    public Employee getEmpDetails() {

        ObjectMapper mapper = new ObjectMapper();
        //Object to JSON in file
        Employee employee =
                mapper.readValue(new File(SRC_MAIN_RESOURCES_DATUM_JSON), Employee.class);

        if (!ObjectUtils.isEmpty(employee)){
            return employee;
        }
            return new Employee();
    }
}
