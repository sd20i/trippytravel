package com.ticket;

import com.trippy.entity.Route;
import com.trippy.entity.TravelCompany;

public class Ticket implements Iticket{

    @Override
    public void createNewTicket(Route route, TravelCompany company, int price) {

        // call database and create ticket
        System.out.println("create ticket in db \n");
        System.out.println("company " + company +"\n");
        System.out.println("Route " + route + "\n");
        System.out.println("price " + price + "\n");
    }

    @Override
    public void getTicketsByRoute(Route route) {
        System.out.println("Will return tickets by routes");
    }
}
