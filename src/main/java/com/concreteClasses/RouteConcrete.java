package com.concreteClasses;

import com.interfaces.IRoute;
import com.trippy.entity.Client;
import com.trippy.entity.Route;
import com.trippy.entity.TravelCompany;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class RouteConcrete implements IRoute {
    private EntityManager em;

    public RouteConcrete(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Route> getAllRoutes(EntityManager em) {
        List routeList;
        try{
            Query queryRoute = em.createQuery("SELECT r FROM Route r");
            routeList = queryRoute.getResultList();
            return routeList;
        }catch(Exception ex){
            System.out.println("route query exception");
            System.out.println(ex);
        }
        return null;
    }

    @Override
    public Route getRouteById(int routeId) {
        try{
            Query queryRoute = em.createQuery("SELECT r FROM Route r WHERE r.routeId =:routeId ");
            queryRoute.setParameter("routeId", routeId);
            Route route = (Route) queryRoute.getSingleResult();
            return route;
        }catch(Exception ex){
            System.out.println("********** Route by id ***********");
            System.out.println(ex);
            System.out.println("**********************************");
        }
            return null;
        }
    }
