package com.mycompany.projectmanagement.service;

import com.mycompany.projectmanagement.dto.PropertyDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Properties;


// We make this to be interface because this log can be reused from more than one class - this call Factory Design pattern

//!!! Factory design patter - one interface  can have multiple implemantion classes of this interface

public interface PropertyService {

    public PropertyDTO saveProperty (PropertyDTO propertyDTO); //user save property and return the same property to him

    public List<PropertyDTO> getAllProperties() ;

    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId); // pass new property which want to update and id of the existing property

    public PropertyDTO updatePropertyDescription( PropertyDTO propertyDTO, Long propertyId);
}
