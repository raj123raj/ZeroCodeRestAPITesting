package com.gfg.zerocode;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/api/users")
public class GeekUserZerocodeApplication {
    private List<GeekUser> users = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(GeekUserZerocodeApplication.class, args);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody GeekUser user) {
        if (!StringUtils.hasText(user.getFirstName())) {
            return new ResponseEntity("firstName can't be empty!", HttpStatus.BAD_REQUEST);
        }
        if (!StringUtils.hasText(user.getLastName())) {
            return new ResponseEntity("lastName can't be empty!", HttpStatus.BAD_REQUEST);
        }
        if (!StringUtils.hasText(user.getDepartmentName())) {
            return new ResponseEntity("DeparmentName can't be empty!", HttpStatus.BAD_REQUEST);
        }
        if (user.getSalary() < 0 ) {
            return new ResponseEntity("Salary is not valid!", HttpStatus.BAD_REQUEST);
        }
        user.setId(UUID.randomUUID()
            .toString());
        users.add(user);
        return new ResponseEntity(user, HttpStatus.CREATED);
    }

}
