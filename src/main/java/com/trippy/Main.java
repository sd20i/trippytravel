package com.trippy;

import com.facades.*;
import com.helper.RandomObject;
import com.trippy.entity.*;
import com.trippy.jpa.DbConnect;
import javax.persistence.EntityManager;
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
        System.out.println(ANSI_BLUE + "Find an client by id 26" + ANSI_RESET);
        Client client1 = clientFacade.getClient(26);
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
        List<Route> availableDestinations = routeFacade.getAvailableRoutes(origin);

        for(Route rou: availableDestinations){
            if(rou.getCityOne().getCityName().equalsIgnoreCase(origin.getCityName())){
                System.out.println(ANSI_GREEN +rou.getCityOne().getCityName() + " - " +rou.getCityTwo().getCityName() + ANSI_RESET);
            }
        }

        int pickRandRouteByOrigin = pickRandom.pickRandomObject(availableDestinations.size());
        Route randomRoute = availableDestinations.get(pickRandRouteByOrigin);
        int destinationRandom = randomRoute.getCityTwo().getCityId();

        City destination = cityFacade.getCityByCityId(destinationRandom);


        //City destination = cityFacade.pickDestination(availableDestinations.get(pickDestinationRand));
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
        if(tickets.size() > 0){
            int pickTicket = pickRandom.pickRandomObject(tickets.size());
            Ticket pickedTicket = tickets.get(pickTicket);

            System.out.println(ANSI_BLUE + "Picked ticket" + ANSI_RESET);

            System.out.println("**************** TICKET *********************");
            System.out.println("From: " + pickedTicket.getRoute().getCityOne().getCityName() + " to " + pickedTicket.getRoute().getCityTwo().getCityName());
            System.out.println("Departure: " + pickedTicket.getDepartureDate() + " - " + pickedTicket.getDepartureTime());
            System.out.println("Arrival: " + pickedTicket.getArrivalDate() + " - " + pickedTicket.getArrivalTime());
            System.out.println("Company: " + pickedTicket.getCompany().getCompanyName());
            System.out.println("Price: " + pickedTicket.getPrice());
            System.out.println("**********************************************\n");

            ticketFacade.addTicketToClient(client1, pickedTicket);
        }else{
            System.out.println("No tickets found");
            System.out.println("Run application again");
        }



    }
}