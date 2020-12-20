package com.facades;

import com.concreteClasses.CityConcrete;
import com.interfaces.ICity;
import com.trippy.entity.City;

import javax.persistence.EntityManager;
import java.util.List;

public class CityFacade {
    private ICity city;

    public CityFacade(EntityManager em) {
        city = new CityConcrete(em);
    }

    public List<City> getAllCities(){
        return city.listCities();
    }

    public City pickCityOrigin(City origin){
        return city.pickOrigin(origin);
    }

    public City getCityByCityId(int cityId){
        City destination = city.getCityById(cityId);
        return destination;
    }
}
