package com.Ticket;
import com.trippy.entity.Route;

public class TicketFacade {
    private Ticket ticket;

    public void TicketMaker() {
        ticket = new Ticket();
    }

    public void createTicket(Route route){
        ticket.create(route);
    }
}