package com.trippy.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="customer")
public class Customer implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name="customerName")
    private String customerName;

    @Column(name="nationality")
    private String nationality;

    @Column(name="isAdult")
    private Boolean isAdult;

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Boolean getAdult() {
        return isAdult;
    }

    public void setAdult(Boolean adult) {
        isAdult = adult;
    }
}