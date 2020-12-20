package com.trippy.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConnect {

    private static final String DB_PU = "trippyPlannerApp";

    private static final DbConnect database = new DbConnect();

    private EntityManagerFactory emf;

    private DbConnect() {}

    public static DbConnect getInstance() {
        return database;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory(DB_PU);
        }
        return emf;
    }
}
