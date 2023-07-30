package com.mycompany.projectmanagement.dto;

import lombok.Getter;
import lombok.Lombok;
import lombok.Setter;

//THIS CLASS IS USE TO HANDLE WITH THE DATA FROM CLIENt and SPRING automatically parse JSON from client to java class

// Lombok - generate setters & getters whit both annotations
@Getter
@Setter
public class PropertyDTO {


    private String title; // type of property(apartment, house & etc..
    private String desciprtion;
    private String address;
    private Double price;
    private String ownerName;
    private String ownerEmail;

//We use Lombok library which remove boiler code
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDesciprtion() {
//        return desciprtion;
//    }
//
//    public void setDesciprtion(String desciprtion) {
//        this.desciprtion = desciprtion;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public String getOwnerName() {
//        return ownerName;
//    }
//
//    public void setOwnerName(String ownerName) {
//        this.ownerName = ownerName;
//    }
//
//    public String getOwnerEmail() {
//        return ownerEmail;
//    }
//
//    public void setOwnerEmail(String ownerEmail) {
//        this.ownerEmail = ownerEmail;
//    }
}
