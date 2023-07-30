package com.mycompany.projectmanagement.controller;
//USE THIS CLASS FOR SCENARIO WHEN CLIENT WANT TO PASS SOME DATA TO UNDERSTAND HOW TO PASS DATA(PARAMETERS)

//PASS PARAMETERS BY URL

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/calculator")   //class level mapping of url to a controller class
public class CalculatorController {
//HERE we have null pointer exception because we don't give instruction of SPRING how to get the PARAMETERS FROM URL
//    @GetMapping("/add")                 //method level mapping of a url to a controller function
//    public Double add(Double num1, Double num2) {
//        return num1 + num2;
//    }

//    VARIANTS TO GET PARAMETERS FROM URL WITH SPRING
//        * @RequestParam("name of parameter")
@GetMapping("/add")         //here num11 is the same name of URL localhost:8080//api/v1/calculator/add?num=11=3.5&num22=3.5
public Double add(@RequestParam("num11") Double num1,@RequestParam("num22") Double num2) { //here use num1 for methods params best practise say to keep the name the same in @RequestParam("num11")Double num1 -> @RequestParam("num1")

    return num1 + num2;
}

}
