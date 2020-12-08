package com.trippy.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleId;

    @Column(name="vehicleName")
    private String vehicleName;

    @Column(name="seats")
    private int seats;

    public int getVehicleId() {
        return vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
