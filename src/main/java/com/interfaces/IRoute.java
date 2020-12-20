package com.interfaces;

import com.trippy.entity.City;
import com.trippy.entity.Route;
import javax.persistence.EntityManager;
import java.util.List;

public interface IRoute {
    List<Route> getAllRoutes(EntityManager em); // maybe not needed em
    Route getRouteById(int routeId);
    List<Route> getAvailableRoutesByOrigin(City origin);
}