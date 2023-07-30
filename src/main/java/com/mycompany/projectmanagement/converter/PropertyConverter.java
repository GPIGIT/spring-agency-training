package com.mycompany.projectmanagement.converter;

import com.mycompany.projectmanagement.dto.PropertyDTO;
import com.mycompany.projectmanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

//BEST PRACTISE TO USE HELPER CLASS which is responsible for converted objects
@Component
public class PropertyConverter {


    public PropertyEntity convertDTOToEntity(PropertyDTO propertyDTO){
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyDTO.getTitle());
        pe.setDescription(propertyDTO.getDescription());
        pe.setAddress(propertyDTO.getAddress());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setPrice(propertyDTO.getPrice());

        return pe;
    }
}
