package com.cts.BM.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity  //Marks the class as a JPA entity — i.e., a persistent object mapped to a table in your database.
@Table(name="Customer")
@Data //Generates boilerplate: getters, setters, toString(), equals(), hashCode(), and required constructors.


public class Customer {

    @Id //Marks the field as the primary key of the entity.
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer customerId; //primary key

    private  String name ;
    private String email;
    private String phone;

    @Column(columnDefinition = "TEXT")
    private String address;

    @Enumerated(EnumType.STRING) //forces db to use enum values line pending
    private  KycStatus kycStatus;

    public enum KycStatus{
        PENDING , VERIFIED
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public KycStatus getKycStatus() {
        return kycStatus;
    }

    public void setKycStatus(KycStatus kycStatus) {
        this.kycStatus = kycStatus;
    }
}
