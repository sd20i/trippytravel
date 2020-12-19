package com.trippy;

import com.facades.ClientFacade;
import com.facades.TicketFacade;
import com.trippy.entity.Client;
import com.trippy.jpa.DbConnect;
import javax.persistence.EntityManager;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        EntityManager em;
        DbConnect connect = DbConnect.getInstance(); // singleton of database connection.
        em = connect.getEntityManagerFactory().createEntityManager();

        ClientFacade clientFacade = new ClientFacade(em);
        TicketFacade ticketFacade = new TicketFacade(em);

        // get client by id.
        Client danni = clientFacade.getClient(20);


        ticketFacade.ticketsByClient(danni);
    }
}