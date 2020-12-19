package com.facades;

import com.concreteClasses.RouteConcrete;
import com.interfaces.IRoute;
import com.trippy.entity.Route;
import com.trippy.entity.TravelCompany;

import javax.persistence.EntityManager;
import java.util.List;

public class RouteFacade {
    private IRoute route;

    public RouteFacade(EntityManager em){
        route = new RouteConcrete(em);
    }

    public Route getRoute(int routeId){
        Route foundRoute = route.getRouteById(routeId);
        return foundRoute;
    };

    public List<Route> getAllRoutes(EntityManager em){
        return route.getAllRoutes(em);
    }
}