package com.mycompany.projectmanagement.service.impl;

import com.mycompany.projectmanagement.dto.PropertyDTO;
import com.mycompany.projectmanagement.service.PropertyService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

// SAY OF SPRING - to get lifecycle of this BEAN(class) - it mean to create instance and destroy it
@Service            // @Configuration @Component @Repository @Controller- those annotations make this class as singleton object, we use Service because it talk to us this will be Business logic which is our service layer
public class PropertyServiceImpl implements PropertyService {

    @Override
    public PropertyDTO saveProperty() {
        return null;
    }
}
