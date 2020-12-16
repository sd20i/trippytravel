package com.ticket;
import com.trippy.entity.Route;
import com.trippy.entity.TravelCompany;

public class TicketFacade {
    private Iticket ticket;

    public TicketFacade() {
        ticket = new Ticket();
    }

    public void createTicket(Route route, TravelCompany company, int price){
        ticket.createNewTicket(route, company, price);
    }
}