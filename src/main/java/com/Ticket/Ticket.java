package com.Ticket;

import com.trippy.entity.Route;

public class Ticket implements Iticket{

    @Override
    public void create(Route route) {
        System.out.println("creating ticket: " + route);
    }
}

/*
Route route,
City destination,
TravelCompany company,
Vehicle vehicle,
double price
*/