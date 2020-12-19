package com.trippy;

import com.facades.*;
import com.trippy.entity.*;
import com.trippy.jpa.DbConnect;
import javax.persistence.EntityManager;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        EntityManager em;
        DbConnect connect = DbConnect.getInstance(); // singleton of database connection.
        em = connect.getEntityManagerFactory().createEntityManager();

        CompanyFacade companyFacade = new CompanyFacade(em);
        RouteFacade routeFacade = new RouteFacade(em);
        TicketFacade ticketFacade = new TicketFacade(em);

        ClientFacade clientFacade = new ClientFacade(em);
        CityFacade cityFacade = new CityFacade(em);


        // flow.
        /*
        1.1 - list all companies OK
        1.2 - pick a company OK
        1.3 - list all routes OK
        1.4 - pick a route OK
        1.5 - create a new ticket OK

        2.1 - pick client by id. OK
        2.2 - pick client by id that doesn't exist (to show null object) OK
        2.3 - list all cities OK
        2.4 - pick a city as origin OK / not OK
        2.5 - show list of destinations available
        2.6 - pick a destination
        2.7 - show ticket list available
        2.8 - pick a ticket
        2.9 - display itinerary
        2.10 - exit
        */

        /*List<TravelCompany> companies = companyFacade.ListCompanies();
        for(TravelCompany com: companies){
            System.out.println(com.getCompanyName());
        }
        TravelCompany pickedCompany = companies.get(2);*/


        // list all routes
        /*List<Route> allRoutes = routeFacade.getAllRoutes(em);
        for(Route r:allRoutes){
            System.out.println(r);
        }
        Route pickedRoute = allRoutes.get(1);*/

        // create ticket
        //ticketFacade.createTicket(pickedRoute, pickedCompany, 200);


        // order process

        //get client by id.
        /*Client client1 = clientFacade.getClient(25);
        Client client2 = clientFacade.getClient(20);
        System.out.println("client1 - " + client1);
        System.out.println("client2 - " + client2);*/

        // get tickets by client
        //ticketFacade.ticketsByClient(danni);

        // list all cities
        //List<City> cities = cityFacade.getAllCities();
        /*for(City c: cities){
            System.out.println(c.getCityName() + "\n");
        }
        */

        /* make sure the origin and destination is not the same
         City origin = cityFacade.pickCityOrigin(this is from cities array);
         City destination = cityFacade.pickDestination(this is from cities array);
        */

        


    }
}