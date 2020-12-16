package com.ticket;

import com.trippy.entity.Route;
import com.trippy.entity.TravelCompany;
import com.trippy.jpa.DbConnect;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketMain {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        TicketFacade ticketFacade = new TicketFacade();

        EntityManager em;
        DbConnect connect = DbConnect.getInstance();
        em = connect.getEntityManagerFactory().createEntityManager();

        //pick company
        List<TravelCompany> companyList = new ArrayList();
        Query queryCompany = em.createQuery("SELECT c FROM TravelCompany c");
        companyList = queryCompany.getResultList();

        // get all routes
        List<Route> routeList = new ArrayList();
        Query queryRoutes = em.createQuery("SELECT e FROM Route e");
        routeList = queryRoutes.getResultList();


        System.out.println("********************************");
        System.out.println("Pick a company from the list");
        System.out.println("********************************");

        for( TravelCompany tc:companyList ) {
            System.out.println(tc.getCompanyId() +" "+ tc.getCompanyName());
        }
        TravelCompany company = companyList.get(userInput.nextInt());
        System.out.println("Company - " + company.getCompanyName() + "\n");


        System.out.println("********************************");
        System.out.println("Pick a route from the list");
        System.out.println("********************************");

        for( Route r:routeList ) {
            System.out.println(r.getCityOne().getCityName() + " - " + r.getCityTwo().getCityName());
        }
        Route route = routeList.get(userInput.nextInt());
        System.out.println("Route - " + route.getCityOne().getCityName() + " - " + route.getCityTwo().getCityName());

        System.out.println("********************************");
        System.out.println("Type a price");
        System.out.println("********************************");

        int price = userInput.nextInt();

        try{
            ticketFacade.createTicket(route, company, price);
        }catch(Exception ex){
            System.out.println(ex);
            throw ex;
        }
    }
}
