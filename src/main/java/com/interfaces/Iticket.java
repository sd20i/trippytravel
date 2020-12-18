package com.interfaces;

import com.trippy.entity.Client;
import com.trippy.entity.Route;
import com.trippy.entity.Ticket;
import com.trippy.entity.TravelCompany;

import javax.persistence.EntityManager;
import java.util.List;

public interface Iticket {
    String createNewTicket(Route route, TravelCompany company, int price);
    List<Ticket> getTicketsByRoute(Route route);
    void getTicketsByClient(Client client);
}
