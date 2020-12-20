package com.trippy;

import com.facades.*;
import com.helper.RandomObject;
import com.trippy.entity.*;
import com.trippy.jpa.DbConnect;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {
        EntityManager em;
        DbConnect connect = DbConnect.getInstance(); // singleton of database connection.
        em = connect.getEntityManagerFactory().createEntityManager();

        RandomObject pickRandom = new RandomObject();

        CompanyFacade companyFacade = new CompanyFacade(em);
        RouteFacade routeFacade = new RouteFacade(em);
        TicketFacade ticketFacade = new TicketFacade(em);
        ClientFacade clientFacade = new ClientFacade(em);
        CityFacade cityFacade = new CityFacade(em);


        // list companies, pick random company
        System.out.println(ANSI_BLUE + "Listing all travel companies" + ANSI_RESET);
        List<TravelCompany> companies = companyFacade.ListCompanies();
        for(TravelCompany com: companies){
            System.out.println(ANSI_GREEN + com.getCompanyName() + ANSI_RESET);
        }
        int pickCompanyRand = pickRandom.pickRandomObject(companies.size());
        TravelCompany pickedCompany = companies.get(pickCompanyRand);
        System.out.println("Company picked: " + ANSI_GREEN + pickedCompany.getCompanyName() + ANSI_RESET);
        System.out.println(ANSI_BLUE + "********************************************\n" + ANSI_RESET);



        // list all routes, pick random route
        List<Route> allRoutes = routeFacade.getAllRoutes(em);
        System.out.println(ANSI_BLUE + "Listing all routes" + ANSI_RESET);
        for(Route r:allRoutes){
            System.out.println(ANSI_GREEN + r.getCityOne().getCityName() + " / " + r.getCityTwo().getCityName() + ANSI_RESET);
        }
        int pickRouteRand = pickRandom.pickRandomObject(allRoutes.size());
        Route pickedRoute = allRoutes.get(pickRouteRand);
        System.out.println("Route picked: " + ANSI_GREEN +  pickedRoute.getCityOne().getCityName() + " to " + pickedRoute.getCityTwo().getCityName() + ANSI_RESET);
        System.out.println(ANSI_BLUE + "********************************************\n" + ANSI_RESET);



        // create a new ticket
        System.out.println(ANSI_BLUE + "Creating a new ticket" + ANSI_RESET);
        Ticket newTicket = ticketFacade.createTicket(pickedRoute, pickedCompany, pickRandom.randomPrice());

        System.out.println(newTicket.getRoute().getCityOne().getCityName() + " to " + newTicket.getRoute().getCityTwo().getCityName());
        System.out.println("Departure: " + newTicket.getDepartureDate() + " - " + newTicket.getDepartureTime());
        System.out.println("Arrival: " + newTicket.getArrivalDate() + " - " + newTicket.getArrivalTime());
        System.out.println("Company: " + newTicket.getCompany().getCompanyName());
        System.out.println("Price: " + newTicket.getPrice());
        System.out.println(ANSI_BLUE + "********************************************\n" + ANSI_RESET);

        System.out.println(ANSI_GREEN+ "************************** TICKET CREATION ENDED **************************\n" + ANSI_RESET);



        // find client, and use null object when not found
        System.out.println(ANSI_BLUE + "Find a client by client id 20. (null object)" + ANSI_RESET);
        clientFacade.getClient(20);
        System.out.println(ANSI_BLUE + "Find an client by id 19" + ANSI_RESET);
        Client client1 = clientFacade.getClient(19);
        System.out.println(ANSI_GREEN + client1.getClientName() + ANSI_RESET);
        System.out.println(ANSI_BLUE + "********************************************\n" + ANSI_RESET);


        // list all cities
        System.out.println(ANSI_BLUE + "Listing all cities" + ANSI_RESET);
        List<City> cities = cityFacade.getAllCities();
        for(City c: cities){
            System.out.println(ANSI_GREEN + c.getCityName() + ANSI_RESET);
        }
        int pickOriginRand = pickRandom.pickRandomObject(cities.size());
        City origin = cityFacade.pickCityOrigin(cities.get(pickOriginRand));
        System.out.println("Origin picked: " + ANSI_GREEN + origin.getCityName()  + ANSI_RESET);
        System.out.println(ANSI_BLUE + "********************************************\n" + ANSI_RESET);



        // list destinations from origin
        System.out.println(ANSI_BLUE + "Listing all destinations from "+ ANSI_RESET + origin.getCityName() + "\n");
        List<City> availableDestinations = routeFacade.getAvailableRoutes(origin);
        List<City> available = new ArrayList<>();
        for(City rou: availableDestinations){
            if(rou.getCityName().equalsIgnoreCase(origin.getCityName())){
                System.out.println(rou.getCityName() + " - " + origin.getCityName());
                availableDestinations.add(rou);
                available.add(rou);
            }
        }
        //TODO: add more routes between all cities.
        for (City availableCities: available){
            System.out.println(ANSI_GREEN + origin.getCityName() +" this to " + availableCities.getCityName() + ANSI_RESET);
        }


        int pickDestinationRand = pickRandom.pickRandomObject(availableDestinations.size());
        City destination = cityFacade.pickDestination(availableDestinations.get(pickDestinationRand));
        System.out.println("Destination picked: " + ANSI_GREEN + destination.getCityName() + ANSI_RESET);

        // picking a route
        Route pickedRouteByClient = null;
        for(Route ar: allRoutes){
            if(ar.getCityOne() == origin && ar.getCityTwo() == destination){
                pickedRouteByClient = ar;
            }
        }
        System.out.println(ANSI_BLUE + "********************************************\n" + ANSI_RESET);

        //show ticket list
        System.out.println(ANSI_BLUE + "Listing available tickets" + ANSI_RESET);
        List<Ticket> tickets = ticketFacade.listTicketsByRoute(pickedRouteByClient);
        for(Ticket tbr: tickets){
            // build ticket view
            System.out.println("**************** TICKET *********************");
            System.out.println("From: " + tbr.getRoute().getCityOne().getCityName() + " to " + tbr.getRoute().getCityTwo().getCityName());
            System.out.println("Departure: " + tbr.getDepartureDate() + " - " + tbr.getDepartureTime());
            System.out.println("Arrival: " + tbr.getArrivalDate() + " - " + tbr.getArrivalTime());
            System.out.println("Company: " + tbr.getCompany().getCompanyName());
            System.out.println("Price: " + tbr.getPrice());
            System.out.println("**********************************************\n");
        }

        // pick random ticket
        int pickTicket = pickRandom.pickRandomObject(tickets.size());

        // TODO!
        /*
            - create ticket picking by client
            - fix creation of ticket not persisting
            - display itinerary by userid
            - make sure it's crashing when tickets array is empty
        */

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
        2.4 - pick a city as origin OK
        2.5 - show list of destinations available OK / buggy
        2.6 - pick a destination OK
        2.7 - show ticket list available OK
        2.8 - pick a ticket OK
        2.9 - display itinerary
        2.10 - exit
        */

    }
}