package com.trippy.jpa;

import com.trippy.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class SeedDatabase {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("trippyPlannerApp");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = null;

        try{
            et = em.getTransaction();
            et.begin();

            // Finnair seeds
            TravelCompany finnair = new TravelCompany();
            finnair.setCompanyName("Finnair");
            em.persist(finnair);
            // Finnair ends

            TravelCompany dsb = new TravelCompany();
            dsb.setCompanyName("DSB");
            em.persist(dsb);


            // SAS seeds
            TravelCompany sas = new TravelCompany();
            sas.setCompanyName("SAS");
            em.persist(sas);
            // SAS ends


            TravelCompany flexBus = new TravelCompany();
            flexBus.setCompanyName("Flex bus");
            em.persist(flexBus);
            //flexbus ends

            // city / country seed
            Country denmark = new Country();
            denmark.setCountryName("Denmark");
            em.persist(denmark);

            City cph = new City();
            cph.setCityName("Copenhagen");
            cph.setCountry(denmark);
            em.persist(cph);

            City aal = new City();
            aal.setCityName("Aalborg");
            aal.setCountry(denmark);
            em.persist(aal);

            Country sweden = new Country();
            sweden.setCountryName("Sweden");
            em.persist(sweden);

            City malmo = new City();
            malmo.setCityName("Malmö");
            malmo.setCountry(sweden);
            em.persist(malmo);

            City goteborg = new City();
            goteborg.setCityName("Goteborg");
            goteborg.setCountry(sweden);
            em.persist(goteborg);

            City stockholm = new City();
            stockholm.setCityName("Stockholm");
            stockholm.setCountry(sweden);
            em.persist(stockholm);
            //city / country ends

            //route seed
            Route cphMal = new Route();
            cphMal.setCityOne(cph);
            cphMal.setCityTwo(malmo);
            em.persist(cphMal);

            Route cphStk = new Route();
            cphStk.setCityOne(cph);
            cphStk.setCityTwo(stockholm);
            em.persist(cphStk);

            Route malStk = new Route();
            malStk.setCityOne(malmo);
            malStk.setCityTwo(stockholm);
            em.persist(malStk);
            //route seed ends

            // ticket seed
            Ticket cphMalTicket = new Ticket();
            cphMalTicket.setCompany(finnair);
            cphMalTicket.setRoute(cphMal);
            cphMalTicket.setDepartureDate("2020-12-09");
            cphMalTicket.setDepartureTime("07:54:00");
            cphMalTicket.setArrivalDate("2020-12-09");
            cphMalTicket.setArrivalTime("08:30:00");
            cphMalTicket.setPrice(200.45);
            em.persist(cphMalTicket);

            Ticket malStkTicket = new Ticket();
            malStkTicket.setRoute(malStk);
            malStkTicket.setCompany(sas);
            malStkTicket.setDepartureDate("2020-12-09");
            malStkTicket.setDepartureTime("09:00:00");
            malStkTicket.setArrivalDate("2020-12-09");
            malStkTicket.setArrivalTime("10:45:00");
            em.persist(malStkTicket);
            // ticket seed ends

            // client seed
            Client client1 = new Client();
            client1.setClientName("Danni");
            client1.setNationality("Dk");
            em.persist(client1);
            //client seed ends

            //itinerary seed
            Itinerary it1 = new Itinerary();
            it1.setTicket(cphMalTicket);
            it1.setClient(client1);
            em.persist(it1);
            //itinerary seed ends
            // end seed
            et.commit();
        }catch(Exception ex){
            if(et != null){
                et.rollback();
                System.out.println("in et != null");
            }
            ex.printStackTrace();
            System.out.println("error");
        }finally {
            em.close();
            emf.close();
        }
    }
}
