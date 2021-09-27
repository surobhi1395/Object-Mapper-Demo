package com.objectmapper.demo.startup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.objectmapper.demo.model.Datum;

import com.objectmapper.demo.model.User;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.*;

@Component
@Log
public class DataUtility {

    @SneakyThrows // find the use of sneaky throws
    public User run() {

        ObjectMapper mapper = new ObjectMapper();
        //Object to JSON in file
        User user = mapper.readValue(new File("src/main/resources/datum.json"), User.class);

       user.getData().sort(comparing(Datum::getEmployeeName));
       Datum datum = user.getData().stream().filter(emp-> {
           if(50 == emp.employeeAge && 300000 == emp.employeeSalary) {
               return true;
           }else
               return false;
       }).findAny().get();

        if (!ObjectUtils.isEmpty(user)){

            return user;
        }
            return new User();
    }
}
