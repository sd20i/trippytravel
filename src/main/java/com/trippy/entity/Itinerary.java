package com.trippy.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "itinerary")
public class Itinerary implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itineraryId;

    @ManyToOne()
    private Client client;

    @OneToOne()
    private Ticket ticket;

    public int getItineraryId() {
        return itineraryId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
