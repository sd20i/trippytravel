package com.travelcompany;

import com.trippy.entity.TravelCompany;
import com.trippy.jpa.DbConnect;
import javax.persistence.EntityManager;
import java.util.List;

public class DeleteMeMain {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        EntityManager em;
        DbConnect connect = DbConnect.getInstance();
        em = connect.getEntityManagerFactory().createEntityManager();

        CompanyFacade companyfacade = new CompanyFacade();

        System.out.println(ANSI_GREEN + "Getting list of companies" + ANSI_RESET);
        List<TravelCompany> companyList = companyfacade.ListCompanies(em);

        for( TravelCompany tc:companyList ) {
            System.out.println(ANSI_PURPLE + tc.getCompanyName() + ANSI_RESET);
        }
        System.out.println(ANSI_BLUE + "*******************************************" + ANSI_RESET);

        System.out.println(ANSI_GREEN + "Picking company" + ANSI_RESET);
        TravelCompany sas = companyfacade.pickCompany(companyList, 2);
        System.out.println(ANSI_PURPLE +  sas.getCompanyName() + ANSI_RESET);
        System.out.println(ANSI_BLUE + "*******************************************" + ANSI_RESET);
    }
}
