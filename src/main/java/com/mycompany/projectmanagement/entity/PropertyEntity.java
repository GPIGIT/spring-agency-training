package com.mycompany.projectmanagement.entity;
// THIS IS DTO but call entity becasue it's represent the layer Repository

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



@Entity  //SPRING now know that is Object for table (ORM)
@Table
//@Table(name = "PROPERTY_TABLE") // give name of table not take default name of the class
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {

    @Id                 // JPA know that is ID Primary Key(PK)
    @GeneratedValue( strategy = GenerationType.AUTO) //  autogenerate values for PK
    private Long id;

//    @Column(name = "PROPERTY_TITLE", nullable = false)  // say how to name the column in table not to get the default name of the properties and set some contrainst
    private String title;
    private String description;
    private String address;
    private Double price;
    private String ownerName;
    private String ownerEmail;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }
}
