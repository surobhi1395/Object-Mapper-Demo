package com.objectmapper.demo.startup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.objectmapper.demo.model.Datum;

import com.objectmapper.demo.model.User;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import lombok.var;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Log
public class DataUtility {

    @SneakyThrows // find the use of sneakythrows
    public User run() {

        ObjectMapper mapper = new ObjectMapper();

        //Object to JSON in file
        User user = mapper.readValue(new File("src/main/resources/datum.json"), User.class);

        user.getData().sort(Comparator.comparing(Datum::getEmployeeName));

        if(ObjectUtils.isEmpty(user)){

            return new User();
        }

        return user;
    }
}
