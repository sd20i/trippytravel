package com.concreteClasses;

import com.google.gson.Gson;
import com.interfaces.Iticket;
import com.trippy.entity.*;

import javax.persistence.*;
import java.util.List;

public class TicketConcrete implements Iticket {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("trippyPlannerApp");
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

            et.commit();
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
    public List<Ticket> getTicketsByClient(Client client) {
        List tickets;
        Query queryTickets = em.createQuery("SELECT i FROM Itinerary i WHERE i.client.id =:clientId ");
        queryTickets.setParameter("clientId", client.getClientId());
        tickets = queryTickets.getResultList();
        return tickets;
    }

    @Override
    public void addTicketToClient(Client client, Ticket ticket) {
        Itinerary itinerary = new Itinerary();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            itinerary.setClient(client);
            itinerary.setTicket(ticket);
            em.persist(itinerary);
            et.commit();
        }catch (Exception ex){
            et.rollback();
            System.out.println("EX " + ex);
        }
    }
}
