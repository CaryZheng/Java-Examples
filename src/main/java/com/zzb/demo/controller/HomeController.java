package com.zzb.demo.controller;

import com.zzb.demo.response.Message;
import com.zzb.demo.response.ResponseWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private static int count = 0;

    @Value("${spring.profiles.active}")
    private String currentEnviroment;

    @GetMapping("/")
    public ResponseEntity<ResponseWrapper> home() {
        ++count;
        String result = "Demo Service Home Page, current enviroment = " + currentEnviroment + ", count = " + count;

        return new ResponseEntity<>(new ResponseWrapper(Message.SUCCESS, result), HttpStatus.OK);
    }
}
