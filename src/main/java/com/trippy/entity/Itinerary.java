package com.trippy.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="itinerary")
public class Itinerary implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itineraryId;

   @OneToOne()
   private Ticket ticket;

   //@OneToOne()
   //private Customer customer;

    public int getItineraryId() {
        return itineraryId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /*public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }*/
}
