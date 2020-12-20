package com.concreteClasses;

import com.interfaces.ICity;
import com.trippy.entity.City;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CityConcrete implements ICity {

    private static EntityManager em;

    public CityConcrete(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<City> listCities() {
        List<City> cityList = new ArrayList<>();

        try{
            Query queryCities = em.createQuery("SELECT c FROM City c");
            cityList = queryCities.getResultList();
        }catch(Exception ex){
            System.out.println(ex);
        }

        return cityList;
    }

    @Override
    public City pickOrigin(City origin) {
        // some text like origin picked
        return origin;
    }

    @Override
    public City getCityById(int cityId) {
        City destination = new City();
        try{
            Query queryCity = em.createQuery("SELECT c FROM City c WHERE c.id = :cityId");
            queryCity.setParameter("cityId", cityId);
            destination = (City) queryCity.getSingleResult();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return destination;
    }


}
