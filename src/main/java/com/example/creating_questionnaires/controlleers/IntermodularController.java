package com.example.creating_questionnaires.controlleers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class IntermodularController {

    @RequestMapping("/auth")
    public ResponseEntity<String> registrationModule() {
        return new RestTemplate().getForEntity("http://localhost:8082/auth", String.class);
    }
}
