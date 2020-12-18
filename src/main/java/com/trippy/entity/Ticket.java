package com.trippy.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="ticket")
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ticketId;

    @OneToOne()
    private Route route;

    @OneToOne
    private TravelCompany company;

    @Temporal(TemporalType.DATE)
    private String departureDate;

    @Basic
    @Temporal(TemporalType.TIME)
    private String departureTime;

    @Temporal(TemporalType.DATE)
    private String arrivalDate;

    @Basic
    @Temporal(TemporalType.TIME)
    private String arrivalTime;

    @Column(name="price")
    private double price;

    public int getTicketId() {
        return ticketId;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public TravelCompany getCompany() {
        return company;
    }

    public void setCompany(TravelCompany company) {
        this.company = company;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
