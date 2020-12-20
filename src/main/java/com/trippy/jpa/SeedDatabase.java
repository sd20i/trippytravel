package com.trippy.jpa;

import com.trippy.entity.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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

            // flex bus seed
            TravelCompany flexBus = new TravelCompany();
            flexBus.setCompanyName("Flex bus");
            em.persist(flexBus);
            //flexbus ends

            // city / country seed
            Country denmark = new Country();
            denmark.setCountryName("Denmark");
            em.persist(denmark);

            Country sweden = new Country();
            sweden.setCountryName("Sweden");
            em.persist(sweden);

            City cph = new City();
            cph.setCityName("Copenhagen");
            cph.setCountry(denmark);
            em.persist(cph);

            City aal = new City();
            aal.setCityName("Aalborg");
            aal.setCountry(denmark);
            em.persist(aal);

            City mal = new City();
            mal.setCityName("Malmö");
            mal.setCountry(sweden);
            em.persist(mal);

            City got = new City();
            got.setCityName("Goteborg");
            got.setCountry(sweden);
            em.persist(got);

            City stk = new City();
            stk.setCityName("Stockholm");
            stk.setCountry(sweden);
            em.persist(stk);
            //city / country ends

            //route seed

            // copenhagen - aalborg
            Route cphAal = new Route();
            cphAal.setCityOne(cph);
            cphAal.setCityTwo(aal);
            em.persist(cphAal);

            // copenhagen - Malmö
            Route cphMal = new Route();
            cphMal.setCityOne(cph);
            cphMal.setCityTwo(mal);
            em.persist(cphMal);

            // copenhagen - Stockholm
            Route cphStk = new Route();
            cphStk.setCityOne(cph);
            cphStk.setCityTwo(stk);
            em.persist(cphStk);

            // aalborg - copenhagen
            Route aalCph = new Route();
            aalCph.setCityOne(aal);
            aalCph.setCityTwo(cph);
            em.persist(aalCph);

            // aalborg - malmø
            Route aalMal = new Route();
            aalMal.setCityOne(aal);
            aalMal.setCityTwo(mal);
            em.persist(aalMal);

            // malmo - copenhagen
            Route malCph = new Route();
            malCph.setCityOne(mal);
            malCph.setCityTwo(cph);
            em.persist(malCph);

            // malmo - stockholm
            Route malStk = new Route();
            malStk.setCityOne(mal);
            malStk.setCityTwo(stk);
            em.persist(malStk);

            // malmo - aalborg
            Route malAal = new Route();
            malAal.setCityOne(mal);
            malAal.setCityTwo(aal);
            em.persist(malAal);

            // Goteborg - copenhagen
            Route gotCph = new Route();
            gotCph.setCityOne(got);
            gotCph.setCityTwo(cph);
            em.persist(gotCph);

            // Goteborg - malmo
            Route gotMal = new Route();
            gotMal.setCityOne(got);
            gotMal.setCityTwo(mal);
            em.persist(gotMal);

            // stockholm - aalborg
            Route stkAal = new Route();
            stkAal.setCityOne(stk);
            stkAal.setCityTwo(aal);
            em.persist(stkAal);

            // stockholm - copenhagen
            Route stkCph = new Route();
            stkCph.setCityOne(stk);
            stkCph.setCityTwo(cph);
            em.persist(stkCph);
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
