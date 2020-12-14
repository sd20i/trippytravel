package com.trippy.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class DbConnect {

    private static final String DB_PU = "trippyPlannerApp";

    public static final boolean DEBUG = true;

    private static final DbConnect singleton = new DbConnect();

    private EntityManagerFactory emf;

    private DbConnect() {}

    public static DbConnect getInstance() {
        return singleton;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory(DB_PU);
        }
        if(DEBUG) {
            System.out.println("factory created on: " + new Date());
        }
        return emf;
    }

    public void closeEmf() {
        if(emf.isOpen() || emf != null) {
            emf.close();
        }
        emf = null;
        if(DEBUG) {
            System.out.println("EMF closed at: " + new Date());
        }
    }
}
