package com.concreteClasses;

import com.google.gson.Gson;
import com.interfaces.Iticket;
import com.trippy.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class TicketConcrete implements Iticket {

    private EntityManager em;

    public TicketConcrete(EntityManager em) {
        this.em = em;
    }

    @Override
    public Ticket createNewTicket(Route route, TravelCompany company, int price) {
        EntityTransaction et = null;
        Ticket newTicket = new Ticket();
        try {
            et = em.getTransaction();
            et.begin();

            newTicket.setRoute(route);
            newTicket.setCompany(company);
            newTicket.setPrice(price);
            newTicket.setDepartureDate("2021-03-01");
            newTicket.setDepartureTime("17:50:00");
            newTicket.setArrivalDate("2021-03-01");
            newTicket.setArrivalTime("18:30:00");
            em.persist(newTicket);

        }catch (Exception ex){
            et.rollback();
            System.out.println("EX " + ex);
        }
        return newTicket;
    }

    @Override
    public List<Ticket> getTicketsByRoute(Route route) {
        List tickets;
        Query queryTickets = em.createQuery("SELECT t FROM Ticket t WHERE t.route.id =:routeId");
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
        //System.out.println(gson.toJson(tickets));
    }
}
