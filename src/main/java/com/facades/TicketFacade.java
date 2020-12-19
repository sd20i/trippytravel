package com.facades;
import com.concreteClasses.TicketConcrete;
import com.interfaces.Iticket;
import com.trippy.entity.Client;
import com.trippy.entity.Route;
import com.trippy.entity.Ticket;
import com.trippy.entity.TravelCompany;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class TicketFacade {
    private Iticket ticket;

    public TicketFacade(EntityManager em) {
        ticket = new TicketConcrete(em);
    }

    public String createTicket(Route route, TravelCompany company, int price, EntityManager em){
        ticket.createNewTicket(route, company, price);
        return "Ticket created";
    };

    public List ticketsByClient(Client client){
      List<Ticket> tickets = new ArrayList<>();
      ticket.getTicketsByClient(client);
      return tickets;
    };
}