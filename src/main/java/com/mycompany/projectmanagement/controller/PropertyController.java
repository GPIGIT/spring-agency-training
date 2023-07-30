package com.mycompany.projectmanagement.controller;

import com.mycompany.projectmanagement.dto.PropertyDTO;
import com.mycompany.projectmanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController         //SPRING now now that class is controll the data from the client browser
@RequestMapping("/api/v1")       //SPRING received instruction to listen for interaction on particular URL -localhost:8080/api/v1/test - /test it's show which method from this class will be execute and what type will be use from REST(GET/PUT/DELETE  ans so on/
public class PropertyController {
        @Autowired // say on SRING to get memory - if not sat that we will have null exception
        private PropertyService propertyService;  //here use Dependency Injection(DI) -SPRING inject automatically our dependencies and now make possible controller to invoke the service layer
                                                  //DI - it's design pattern which make decouple of code and make it extensible & scalable
 //HERE JUST SAMPLE METHOD try to see it works
    @GetMapping("/test")   //Sat on SPRING this is getter method which work on base on REST API Architecture
    public String sayHello(){
        return "Hello";
    }


    @PostMapping("/properties")
    public  ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {
       propertyDTO = propertyService.saveProperty(propertyDTO);
        System.out.println(propertyDTO);
//                    <type of return data>               < type of resullt, PK>
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/properties")
    public  ResponseEntity<List<PropertyDTO>>  getAllProperties() {

      List<PropertyDTO> propertyList = propertyService.getAllProperties();
      ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<List<PropertyDTO>>(propertyList,HttpStatus.OK);

      return responseEntity;
    }

    @PutMapping("/properties/{propertyId}")  // example Full update in DB
    public  ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){

      propertyDTO =    propertyService.updateProperty(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/properties/update-description/{propertyId}")   // example partial update in DB
    public  ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){

        propertyDTO =    propertyService.updatePropertyDescription(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/properties/{propertyId}")
    public ResponseEntity deleteProperty(@PathVariable Long propertyId){
        propertyService.deleteProperty(propertyId);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return responseEntity;
    }
}
