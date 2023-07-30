package com.mycompany.projectmanagement.service;

import com.mycompany.projectmanagement.dto.PropertyDTO;


// We make this to be interface because this log can be reused from more than one class - this call Factory Design pattern

//!!! Factory design patter - one interface  can have multiple implemantion classes of this interface

public interface PropertyService {

    public PropertyDTO saveProperty (); //user save property and return the same property to him

}
