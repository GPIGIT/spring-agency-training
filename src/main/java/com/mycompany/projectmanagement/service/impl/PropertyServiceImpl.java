package com.mycompany.projectmanagement.service.impl;

import com.mycompany.projectmanagement.converter.PropertyConverter;
import com.mycompany.projectmanagement.dto.PropertyDTO;
import com.mycompany.projectmanagement.entity.PropertyEntity;
import com.mycompany.projectmanagement.repository.PropertyRepository;
import com.mycompany.projectmanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
         propertyEntity =  propertyRepository.save(propertyEntity); // After save in DB JPA will return ID from DB

          // now want to take PK from DB and return to user
        propertyDTO = propertyConverter.convertEntityToDTO(propertyEntity);

        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
           List<PropertyEntity> listOfProperties = (List<PropertyEntity>)propertyRepository.findAll();
           List<PropertyDTO> propList = new ArrayList<>();

            for ( PropertyEntity pe : listOfProperties) {
               PropertyDTO dto =  propertyConverter.convertEntityToDTO(pe);
               propList.add(dto);
            }
            return propList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        //first get id of the row which wan to update
         Optional<PropertyEntity> optionalEntity = propertyRepository.findById(propertyId);
         PropertyDTO dto = null;

         if(optionalEntity.isPresent()){
            PropertyEntity pe = optionalEntity.get();  //data from DB down lines override the columns
            pe.setTitle(propertyDTO.getTitle());
            pe.setDescription(propertyDTO.getDescription());
            pe.setAddress(propertyDTO.getAddress());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            pe.setOwnerName(propertyDTO.getOwnerName());
            pe.setPrice(propertyDTO.getPrice());
             dto = propertyConverter.convertEntityToDTO(pe);
             propertyRepository.save(pe); //here save changes in to DB
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optionalEntity = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;

        if (optionalEntity.isPresent()) {
            PropertyEntity pe = optionalEntity.get();  //data from DB down line override the column description
            pe.setDescription(propertyDTO.getDescription());

            dto = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe); //here save changes in to DB

        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
