package com.interfaces;

import com.trippy.entity.*;
import java.util.List;

public interface Iticket {
    Ticket createNewTicket(Route route, TravelCompany company, int price);
    List<Ticket> getTicketsByRoute(Route route);
    void getTicketsByClient(Client client);
}
