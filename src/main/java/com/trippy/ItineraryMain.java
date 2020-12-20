package com.trippy;

import com.facades.ClientFacade;
import com.facades.TicketFacade;
import com.iterator.ItinerarysRepository;
import com.trippy.entity.Client;
import com.trippy.entity.Itinerary;
import com.trippy.jpa.DbConnect;

import javax.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;

public class ItineraryMain {


    public static void main(String[] args) {
        EntityManager em;
        DbConnect connect = DbConnect.getInstance(); // singleton of database connection.
        em = connect.getEntityManagerFactory().createEntityManager();


        ClientFacade clientFacade = new ClientFacade(em);
        TicketFacade ticketFacade = new TicketFacade(em);

        Client client1 = clientFacade.getClient(26);

        List<Itinerary> itineraries;

        itineraries = ticketFacade.ticketsByClient(client1);


        ItinerarysRepository repository = new ItinerarysRepository(itineraries);

        System.out.println("********************* Client *******************");
        System.out.println(client1.getClientName());
        System.out.println("************************************************ \n");

        for(Iterator iter = repository.getIterator(); iter.hasNext();){
            Itinerary itinerary = (Itinerary) iter.next();
            System.out.println(itinerary.getItineraryId());
            System.out.println("Origin / destination: " + itinerary.getTicket().getRoute().getCityOne().getCityName() + " to " + itinerary.getTicket().getRoute().getCityTwo().getCityName());
            System.out.println("Departure: "+itinerary.getTicket().getDepartureDate() +" - "+ itinerary.getTicket().getDepartureTime());
            System.out.println("Arrival: " + itinerary.getTicket().getArrivalDate() +" - "+ itinerary.getTicket().getArrivalTime());
            System.out.println("Price: " + itinerary.getTicket().getPrice());
            System.out.println("************************************************ \n");
        }
    }
}
