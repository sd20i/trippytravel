package com.trippy;

import com.orderTicket.OrderTicket;
import com.trippy.entity.City;
import com.trippy.entity.Route;
import com.trippy.jpa.DbConnect;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        EntityManager em;
        DbConnect connect = DbConnect.getInstance();
        em = connect.getEntityManagerFactory().createEntityManager();

       City origin = em.find(City.class, (int) 14);
       City destination = em.find(City.class, (int) 15);

       OrderTicket orderticket = new OrderTicket();

       orderticket.orderBusTicket(origin, destination);

    }
}
/*
boolean running = true;
        Gson gson = new Gson();
        System.out.println("Welcome to trippy travel");
        System.out.println("***********************************");

        EntityManager em;

        DbConnect connect = DbConnect.getInstance();

        em = connect.getEntityManagerFactory().createEntityManager();

        Query queryCities = em.createQuery("Select r " + "from Route r " + "ORDER BY r.id ASC");

        List<Route> list = (List<Route>)queryCities.getResultList( );

        for( Route r:list ) {
            System.out.println(gson.toJson(r));
            System.out.println("--------------------------------");
        }

    /*
            Maybe we skip this?
            1: Seats on vehicle
            2: Amount of tickets available


            Buying a ticket as customer.

             1: welcome message.
             2: ask customer to pick an origin from the list of routes.
             3: show list of destinations from routes, exclude origin. (cannot travel from cph to cph)
             4: Customer picks a destination.
             5: System shows route offers. by company and vehicles: plane, bus, train.
             6: Customer picks a ticket.
             7: Customer enters customer data.
             8: System creates an itinerary.


            Creating tickets as company.

             1: Company picks a route.
             2: Company assigns a vehicle to use.
             3: System creates tickets based on vehicle seats.
        */
