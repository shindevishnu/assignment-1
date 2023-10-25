package com.bntsoft.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetapi")
public class GreetController {


   @GetMapping(path = "/v1/hello")
    public ResponseEntity<String> greet(@RequestParam(name = "name", required = false) String name){
       String greetMessage = "";
       if(name != null){
            greetMessage = "Hello " + name + "!!";
       } else {
           greetMessage = "Hello World!!";
       }
        return ResponseEntity.ok(greetMessage);
    }

}
