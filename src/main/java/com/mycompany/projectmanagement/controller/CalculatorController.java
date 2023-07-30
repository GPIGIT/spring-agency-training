package com.mycompany.projectmanagement.controller;
//USE THIS CLASS FOR SCENARIO WHEN CLIENT WANT TO PASS SOME DATA TO UNDERSTAND HOW TO PASS DATA(PARAMETERS)

//PASS PARAMETERS BY URL

import ch.qos.logback.core.boolex.EvaluationException;
import com.mycompany.projectmanagement.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v1/calculator")   //class level mapping of url to a controller class
public class CalculatorController {
//HERE we have null pointer exception because we don't give instruction of SPRING how to get the PARAMETERS FROM URL
//    @GetMapping("/add")                 //method level mapping of a url to a controller function
//    public Double add(Double num1, Double num2) {
//        return num1 + num2;
//    }

//    VARIANTS TO GET PARAMETERS FROM URL WITH SPRING
    //  * @RequestParam("name of parameter")

            @GetMapping("/add")         //here num11 is the same name of URL localhost:8080//api/v1/calculator/add?num=11=3.5&num22=3.5
            public Double add(@RequestParam("num11") Double num1,@RequestParam("num22") Double num2) { //here use num1 for methods params best practise say to keep the name the same in @RequestParam("num11")Double num1 -> @RequestParam("num1")

                return num1 + num2;
            }

    // * @PathVariable("name of param") - Map the values of url to java variables by Path variable method
    // syntax: {name_of_param}

            @GetMapping("/sub/{num1}/{num2}")  //URL -localhost:8080/api/v1/calculator/sub/4.8/1.5 -last are parameters
            public Double substract (@PathVariable("num1") Double num1,@PathVariable("num2") Double num2) {
                Double result = null;
                if(num1 > num2){
                    result = num1 - num2;
                } else {
                    result = num2 - num1;
                }
                return result;
            }

    // * combine @PathVariable & @RequestParam

    @GetMapping("/combine/{num3}")  //URL - localhost:8080/api/v1/calculator/combine/3?&num1=3.5&num2=2
    public Double add(@RequestParam("num1") Double num1,@RequestParam("num2") Double num2, @PathVariable("num3")Double num3) {

        return num1 + num2 + num3;
    }


    // * @PostMapping("/mul")  scenario when want to handle with sequence of params wich will map to variables inside the  CalculatorDTO.class
    // here receive data in JSON format which keep data in key : value pair
//    {
//            "num1": 3,
//            "num2": 4,
//            "num4":1
//    }
            @PostMapping("/mul")
            public ResponseEntity<Double> multiply (@RequestBody CalculatorDTO calculatorDTO) {  // before Response entity was simple Double
                Double result = null;
                result = calculatorDTO.getNum1() * calculatorDTO.getNum2() * calculatorDTO.getNum4();

                //Scenario WHEN WE WANT TO RETURN AND HTTP RESPONSE CODE
                //<here return type of method>        <return type of method> (result, status of http)
                ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED); //HttpStatus.CREATED - value is 201
               return responseEntity; // result was before Response entity
            }
}
