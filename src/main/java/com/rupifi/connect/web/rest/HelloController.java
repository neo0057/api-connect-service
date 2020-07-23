package com.rupifi.connect.web.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rupifi.connect.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/health-check")
public class HelloController {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<?> getHealth() {
        logger.info("health check request");
        User user = new User();
        user.setName("Ajeet");
        user.setMobileNumber(123);
        logger.info("user json: {}", user.toString());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
