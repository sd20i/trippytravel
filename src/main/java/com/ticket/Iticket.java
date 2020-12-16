package com.ticket;

import com.trippy.entity.Route;
import com.trippy.entity.TravelCompany;

public interface Iticket {
    void createNewTicket(Route route, TravelCompany company, int price);
    void getTicketsByRoute(Route route);
}
