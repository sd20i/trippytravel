package com.facades;
import com.concreteClasses.TicketConcrete;
import com.interfaces.Iticket;
import com.trippy.entity.*;

import javax.persistence.EntityManager;
import java.util.List;

public class TicketFacade {
    private Iticket ticket;

    public TicketFacade(EntityManager em) {
        ticket = new TicketConcrete(em);
    }

    public Ticket createTicket(Route route, TravelCompany company, int price){
        return ticket.createNewTicket(route, company, price);
    };

    public List<Itinerary> ticketsByClient(Client client){
        return ticket.getTicketsByClient(client);
    };

    public List<Ticket> listTicketsByRoute(Route route){
        return ticket.getTicketsByRoute(route);
    }

    public void addTicketToClient(Client client, Ticket clientTicket){
        ticket.addTicketToClient(client, clientTicket);

    }
}