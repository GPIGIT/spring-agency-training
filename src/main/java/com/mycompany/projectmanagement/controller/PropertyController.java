package com.mycompany.projectmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController         //SPRING now now that class is controll the data from the client browser
@RequestMapping("/api/v1/")       //SPRING receive instruction to listten for iteraction on particular URL -localhost:8080/api/v1/test - /test it's show which method from this class will be execute and what type will be use from REST(GET/PUT/DELETE  ans so on/
public class PropertyController {

 //HERE JUST SAMPLE METHOD try to see it works
    @GetMapping("/test")   //Sat on SPRING this is getter method which work on base on REST API Architecture
    public String sayHello(){
        return "Hello";
    }
}
