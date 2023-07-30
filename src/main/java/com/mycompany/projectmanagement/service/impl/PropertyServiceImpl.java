package com.mycompany.projectmanagement.service.impl;

import com.mycompany.projectmanagement.converter.PropertyConverter;
import com.mycompany.projectmanagement.dto.PropertyDTO;
import com.mycompany.projectmanagement.entity.PropertyEntity;
import com.mycompany.projectmanagement.repository.PropertyRepository;
import com.mycompany.projectmanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// SAY OF SPRING - to get lifecycle of this BEAN(class) - it mean to create instance and destroy it
@Service            // @Configuration @Component @Repository @Controller- those annotations make this class as singleton object, we use Service because it talk to us this will be Business logic which is our service layer
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository; //say on SPRING to inject here our propertylayer and now our servie layer can talk with Repository layer

    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
            // convert propertyDTO to Entity type
            // Adapter design pattern - one layer use one type od data and another need diffrent type of data we need make compatibility conversation

        PropertyEntity propertyEntity = propertyConverter.convertDTOToEntity(propertyDTO);
        propertyRepository.save(propertyEntity);
        return propertyDTO;
    }
}
