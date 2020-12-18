package com.concreteClasses;

import com.interfaces.Iticket;
import com.trippy.entity.Client;
import com.trippy.entity.Route;
import com.trippy.entity.Ticket;
import com.trippy.entity.TravelCompany;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TicketConcrete implements Iticket {

    private EntityManager em;

    public TicketConcrete(EntityManager em) {
        this.em = em;
    }

    @Override
    public String createNewTicket(Route route, TravelCompany company, int price) {

        Ticket newTicket = new Ticket();
        newTicket.setRoute(route);
        newTicket.setCompany(company);
        newTicket.setPrice(price);
        newTicket.setDepartureDate("");
        newTicket.setDepartureTime("");
        newTicket.setArrivalDate("");
        newTicket.setArrivalTime("");
        em.persist(newTicket);

        return "Ticket created";
    }

    @Override
    public List<Ticket> getTicketsByRoute(Route route) {
        List tickets;
        Query queryTickets = em.createQuery("SELECT t FROM Ticket t WHERE t.route.id =:routeId ");
        queryTickets.setParameter("routeId", route.getRouteId());
        tickets = queryTickets.getResultList();
        return tickets;
    }

    @Override
    public void getTicketsByClient(Client client) {
        List tickets;
        Query queryTickets = em.createQuery("SELECT i FROM Itinerary i WHERE i.client.id =:clientId ");
        queryTickets.setParameter("clientId", client.getClientId());
        tickets = queryTickets.getResultList();
        System.out.println(tickets);
    }
}
