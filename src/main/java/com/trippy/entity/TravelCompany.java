package com.trippy.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "company")
public class TravelCompany implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int companyId;

    @Column(name="companyName")
    private String companyName;

    @OneToMany()
    private List<Vehicle> vehicleList;

    public int getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
}
