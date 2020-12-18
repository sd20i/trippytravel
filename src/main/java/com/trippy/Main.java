package com.trippy;

import com.facades.TicketFacade;
import com.trippy.entity.Client;
import com.trippy.jpa.DbConnect;
import javax.persistence.EntityManager;


public class Main {


    public static void main(String[] args) {
        EntityManager em;
        DbConnect connect = DbConnect.getInstance();
        em = connect.getEntityManagerFactory().createEntityManager();


        TicketFacade ticketFacade = new TicketFacade(em);

        //ticketFacade.ticketsByClient(danni);
    }
}