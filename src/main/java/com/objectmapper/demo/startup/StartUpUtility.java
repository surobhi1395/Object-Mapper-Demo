package com.objectmapper.demo.startup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.objectmapper.demo.model.Datum;
import com.objectmapper.demo.repository.EmployeeRepo;
import lombok.Data;
import lombok.Value;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Data
@Component
@Log
public class StartUpUtility implements CommandLineRunner {

    @Value("${demo.json.string}")
    private String json;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Datum datum = objectMapper.readValue(json, Datum.class);
        Datum save = employeeRepo.save(datum);
        log.info(save.toString());
    }
}
