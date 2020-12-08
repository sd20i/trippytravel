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
            Vehicle finnairplane1 = new Vehicle();
            finnairplane1.setVehicleName("Ay394");
            finnairplane1.setSeats(130);
            em.persist(finnairplane1);

            Vehicle finnairplane2 = new Vehicle();
            finnairplane2.setVehicleName("Ay666");
            finnairplane2.setSeats(200);
            em.persist(finnairplane2);

            TravelCompany finnair = new TravelCompany();
            finnair.setCompanyName("Finnair");
            List finnairVehicleList = new ArrayList();
            finnairVehicleList.add(finnairplane1);
            finnairVehicleList.add(finnairplane2);
            finnair.setVehicleList(finnairVehicleList);
            em.persist(finnair);
            // Finnair ends

            // SAS seeds
            Vehicle sasplane1 = new Vehicle();
            sasplane1.setVehicleName("sk111");
            sasplane1.setSeats(180);
            em.persist(sasplane1);

            Vehicle sasplane2 = new Vehicle();
            sasplane2.setVehicleName("sk977");
            sasplane2.setSeats(90);
            em.persist(sasplane2);

            Vehicle sasplane3 = new Vehicle();
            sasplane3.setVehicleName("sk999");
            sasplane3.setSeats(300);
            em.persist(sasplane3);

            TravelCompany sas = new TravelCompany();
            sas.setCompanyName("SAS");
            List sasVehicleList = new ArrayList();
            sasVehicleList.add(sasplane1);
            sasVehicleList.add(sasplane2);
            sasVehicleList.add(sasplane3);
            sas.setVehicleList(sasVehicleList);
            em.persist(sas);
            // SAS ends

            // flexbus seeds
            Vehicle flexbus1 = new Vehicle();
            flexbus1.setVehicleName("E55");
            flexbus1.setSeats(50);
            em.persist(flexbus1);

            TravelCompany flexBus = new TravelCompany();
            flexBus.setCompanyName("Flex bus");
            List flexVehicleList = new ArrayList();
            flexVehicleList.add(flexbus1);
            flexBus.setVehicleList(flexVehicleList);
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
            cphMalTicket.setRoute(cphMal);
            cphMalTicket.setCompany(finnair);
            cphMalTicket.setVehicle(finnair.getVehicleList().get(1));
            cphMalTicket.setDepartureDate("2020-12-09");
            cphMalTicket.setDepartureTime("07:54:00");
            cphMalTicket.setArrivalDate("2020-12-09");
            cphMalTicket.setArrivalTime("08:30:00");
            cphMalTicket.setPrice(200.45);
            em.persist(cphMalTicket);

            Ticket malStkTicket = new Ticket();
            malStkTicket.setRoute(malStk);
            malStkTicket.setCompany(sas);
            malStkTicket.setVehicle(sas.getVehicleList().get(1));
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
            }
            ex.printStackTrace();
            System.out.println("error");
        }finally {
            em.close();
            emf.close();
        }

    }
}
